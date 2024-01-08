package com.taxi.Taxi.util;

import org.apache.commons.lang3.RandomStringUtils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class RandomGenerateUtil {

	public static String tripBookingCode() throws Exception {
		try {
			return "TBC-" + RandomStringUtils.random(6, "0123456789T");
		} catch (Exception exception) {
			log.error(exception.getMessage());
			throw new Exception("NOT GENERATE");
		}
	}

}
