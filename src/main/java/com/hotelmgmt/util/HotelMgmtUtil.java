package com.hotelmgmt.util;

import java.util.UUID;

public class HotelMgmtUtil {

	public static boolean checkForValidUUID(String uuidString) {
		if (null != UUID.fromString(uuidString)) {
			return true;
		}
		return false;
	}
}
