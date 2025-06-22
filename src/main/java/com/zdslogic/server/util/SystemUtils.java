package com.zdslogic.server.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/*
import com.zdslogic.server.applications.common.dto.WhoisDto;
import com.zdslogic.server.applications.system.domain.ApiKeyEntity;
import com.zdslogic.server.applications.system.repo.ApiKeyRepository;
import com.zdslogic.server.applications.system.service.RawDBDemoGeoIPLocationService;
import com.zdslogic.server.common.dto.GeoIpDto;
import com.zdslogic.server.config.StaticContextAccessor;
import com.zdslogic.server.logs.domain.HttpAccessLogEntity;
import com.zdslogic.server.logs.service.HttpAccessLogService;
import com.zdslogic.server.whois.MyWhoisUtil;
*/
import jakarta.servlet.http.HttpServletRequest;

public class SystemUtils {

	private static final String[] IP_HEADER_CANDIDATES = { "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP",
			"HTTP_X_FORWARDED_FOR", "HTTP_X_FORWARDED", "HTTP_X_CLUSTER_CLIENT_IP", "HTTP_CLIENT_IP",
			"HTTP_FORWARDED_FOR", "HTTP_FORWARDED", "HTTP_VIA", "REMOTE_ADDR" };

	private static final Logger LOGGER = LoggerFactory.getLogger(SystemUtils.class);

	// static variable single_instance of type Singleton
	private static SystemUtils instance = null;

	// @Autowired
	// ApiKeyService apiKeyService;

	public static final String IANA_WHOIS_SERVER = "whois.iana.org";
	public static final int WHOIS_PORT = 43;

	// private constructor restricted to this class itself
	private SystemUtils() {
		// this.apiKeyService = apiKeyService;
	}

	// static method to create instance of Singleton class
	public static SystemUtils getInstance() {
		if (instance == null)
			instance = new SystemUtils();

		return instance;
	}

	private static boolean isHostname(String host) {

		// is this a ipv6 address
		if (host.indexOf(":") != -1)
			return false;

		char[] ca = host.toCharArray();
		// if we see a character that is neither a digit nor a period
		// then host is probably a hostname
		for (int i = 0; i < ca.length; i++) {
			if (!Character.isDigit(ca[i])) {
				if (ca[i] != '.')
					return true;
			}
		}
		// Everything was either a digit or a period
		// so host looks like a ip4v address in dotted quad format

		return false;
	}// end ishostname


	public static String exceptionStacktraceToString(Exception e) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		ps.close();
		return baos.toString();
	}

	public boolean isApiKeyValid(String apiKey) {
/*
		ApiKeyRepository apiKeyRepo = StaticContextAccessor.getBean(ApiKeyRepository.class);

		ApiKeyEntity entity = apiKeyRepo.findByApiKey(apiKey);

		if (entity != null) {
			return true;
		}

		return false;
*/
		return true;
	}

	public static String getClientIpAddressIfServletRequestExist() {

		if (RequestContextHolder.getRequestAttributes() == null) {
			return "0.0.0.0";
		}

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		for (String header : IP_HEADER_CANDIDATES) {
			String ipList = request.getHeader(header);
			if (ipList != null && ipList.length() != 0 && !"unknown".equalsIgnoreCase(ipList)) {
				String ip = ipList.split(",")[0];
				return ip;
			}
		}

		return request.getRemoteAddr();
	}

	public static String replaceEmbeddedQuotes(String input) {
		String progress = "";
		for (int c = 0; c < input.length(); c++) {
			char ch = input.charAt(c);
			if (ch == '\\') { // Skip if the next character is already escaped
				c++;
				continue;
			}
			if (ch == '\"')
				progress += "\\\""; // Results in \"
			else
				progress += ch; // Add the character to progress
		}
		return progress;
	}
	
    public static String getClientIp(HttpServletRequest request) {
        String remoteAddr = "";
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        return remoteAddr;
    }
    
}
