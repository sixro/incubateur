package burgeonapp;

import java.text.MessageFormat;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.slf4j.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class AutoDefaultMessageSource extends ReloadableResourceBundleMessageSource {

	private static final Logger LOG = LoggerFactory.getLogger(AutoDefaultMessageSource.class);

	@Override
	protected String resolveCodeWithoutArguments(String code, Locale locale) {
		LOG.info("resolving code without args '{}' for locale {}...", code, locale);
		String value = super.resolveCodeWithoutArguments(code, locale);
		String resolved = value == null ? defaultValue(code) : value;
		LOG.info("... returning '{}'", resolved);
		return resolved;
	}

	@Override
	protected MessageFormat resolveCode(String code, Locale locale) {
		LOG.info("resolving code '{}' for locale {}...", code, locale);
		MessageFormat messageFormat = super.resolveCode(code, locale);
		return messageFormat;
	}

	private String defaultValue(String code) {
		return WordUtils.capitalizeFully(StringUtils.replace(code, "_", " "));
	}

}
