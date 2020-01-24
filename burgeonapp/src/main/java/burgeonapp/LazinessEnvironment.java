package burgeonapp;

import org.apache.commons.lang3.*;
import org.slf4j.*;
import org.springframework.core.env.Environment;

public class LazinessEnvironment implements Environment {

	private static final Logger LOG = LoggerFactory.getLogger(LazinessEnvironment.class);

	private final Environment environment;

	public LazinessEnvironment(Environment environment) {
		this.environment = environment;
	}

	@Override
	public boolean containsProperty(String key) {
		return getProperty(key) != null;
	}

	@Override
	public String getProperty(String key) {
		String value = null;
		while (true) {
			LOG.info("Evaluating property '{}'...", key);
			value = environment.getProperty(key);
			if (value != null)
				break;

			String[] parts = StringUtils.split(key, '.');
			if (parts.length == 1)
				break;

			String[] newParts = ArrayUtils.remove(parts, parts.length - 2);
			key = StringUtils.join(newParts, ".");
		}
		LOG.info("... returning '{}'", value);
		return value;
	}

	@Override
	public String getProperty(String key, String defaultValue) {
		String value = getProperty(key);
		return value != null ? value : defaultValue;
	}

	@Override
	public <T> T getProperty(String key, Class<T> targetType) {
		T value = null;
		while (true) {
			LOG.info("Evaluating property '{}'...", key);
			value = environment.getProperty(key, targetType);
			if (value != null)
				break;

			String[] parts = StringUtils.split(key, '.');
			if (parts.length == 1)
				break;

			String[] newParts = ArrayUtils.remove(parts, parts.length - 2);
			key = StringUtils.join(newParts, ".");
		}
		LOG.info("... returning '{}'", value);
		return value;
	}

	@Override
	public <T> T getProperty(String key, Class<T> targetType, T defaultValue) {
		T value = getProperty(key, targetType);
		return value != null ? value : defaultValue;
	}

	@SuppressWarnings("deprecation")
	@Override
	public <T> Class<T> getPropertyAsClass(String key, Class<T> targetType) {
		return environment.getPropertyAsClass(key, targetType);
	}

	@Override
	public String getRequiredProperty(String key) throws IllegalStateException {
		return environment.getRequiredProperty(key);
	}

	@Override
	public <T> T getRequiredProperty(String key, Class<T> targetType) throws IllegalStateException {
		return environment.getRequiredProperty(key, targetType);
	}

	@Override
	public String resolvePlaceholders(String text) {
		return environment.resolvePlaceholders(text);
	}

	@Override
	public String resolveRequiredPlaceholders(String text) throws IllegalArgumentException {
		return environment.resolveRequiredPlaceholders(text);
	}

	@Override
	public String[] getActiveProfiles() {
		return environment.getActiveProfiles();
	}

	@Override
	public String[] getDefaultProfiles() {
		return environment.getDefaultProfiles();
	}

	@Override
	public boolean acceptsProfiles(String... profiles) {
		return environment.acceptsProfiles(profiles);
	}

}