package burgeonapp;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StrSubstitutor;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultController.class);

	private final LazinessEnvironment environment;
	private final DB db;

	@Autowired
	public DefaultController(Environment environment, DB db) {
		this(new LazinessEnvironment(environment), db);
	}

	public DefaultController(LazinessEnvironment environment, DB dB) {
		super();
		this.environment = environment;
		this.db = dB;
	}

	@RequestMapping("/")
	public ModelAndView handle() {
		LOG.info("appTitle: {}", environment.getProperty("app.title"));

		String menuAsText = environment.getProperty("menus", "home");
		String[] menu = StringUtils.split(menuAsText, ",");

		return new ModelAndView("redirect:/" + menu[0]);
	}

	@RequestMapping("/{menu}")
	public ModelAndView retrieve(@PathVariable String menu) {
		LOG.info("handling 'list' for menu '{}' ...", menu);

		List<String> items = findItems(menu);

		LOG.info("... obtained items {}...", items);
		if (items.isEmpty())
			throw new RuntimeException("404 not found");
		return new ModelAndView("redirect:/" + menu + "/" + items.get(0));
	}

	@RequestMapping("/{menu}/{item}")
	public ModelAndView retrieve(@PathVariable String menu, @PathVariable String item, @RequestParam(value="pn", defaultValue="0") int pageNumber) {
		LOG.info("handling 'list' for menu '{}' and item '{}' ...", menu, item);

		String menuAsText = environment.getProperty("menus", "home");
		String[] menus = StringUtils.split(menuAsText, ",");
		List<String> items = findItems(menu);
		LOG.info("... obtained items {} for menu '{}'...", items, menu);

		HashMap<String, Object> placeholders = new HashMap<>();
		placeholders.put("menu", menu);
		placeholders.put("item", item);
		String property = StrSubstitutor.replace("${menu}.${item}.retrieve-sql", placeholders);
		String retrieveSqlTemplate = environment.getProperty(property, "select * from @{item}");
		String retrieveSql = StrSubstitutor.replace(retrieveSqlTemplate, placeholders, "@{", "}");

		property = StrSubstitutor.replace("${menu}.${item}.retrieve-maximize-column", placeholders);
		String maximizeColumn = environment.getProperty(property);

		property = StrSubstitutor.replace("${menu}.${item}.retrieve-paging-snippet", placeholders);
		String retrievePageSnippet = environment.getProperty(property, "limit ((:pageNumber * :pageSize) + :pageSize) offset (:pageNumber * :pageSize)");

		property = StrSubstitutor.replace("${menu}.${item}.retrieve-page-size", placeholders);
		int pageSize = environment.getProperty(property, Integer.class, 8);

		PageData pageData = db.loadPageData(retrieveSql, retrievePageSnippet, pageNumber, pageSize);
		LOG.info("page data: {}", pageData);
		
		ModelAndView mv = new ModelAndView("retrieve");
		mv.addObject("appTitle", environment.getProperty("app.title", "Burgeonapp"));
		mv.addObject("e", environment);
		mv.addObject("menus", menus);
		mv.addObject("items", items);
		mv.addObject("menu", menu);
		mv.addObject("item", item);
		mv.addObject("rows", pageData.getData());
		mv.addAllObjects(pageData.getMeta());
		mv.addObject("maximizeColumn", maximizeColumn);

		LOG.info("... returning {}", mv);
		return mv;
	}

	private List<String> findItems(String menu) {
		String[] includePatterns = StringUtils.split(environment.getProperty(menu + ".include-tables", ".*"), ",");
		String[] excludePatterns = StringUtils.split(environment.getProperty(menu + ".exclude-tables"), ",");
		LOG.debug("... includePatterns({}): {}, excludePatterns({}): {} ...", includePatterns.length, includePatterns,
				excludePatterns.length, excludePatterns);
		List<String> items = db.findTableNames(includePatterns, excludePatterns);
		return items;
	}

}
