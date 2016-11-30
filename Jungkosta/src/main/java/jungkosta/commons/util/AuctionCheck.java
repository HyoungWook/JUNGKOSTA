package jungkosta.commons.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AuctionCheck {

	public static boolean compareTime(Timestamp time) {

		Calendar cal = Calendar.getInstance();

		Date date = new Date(cal.getTimeInMillis());
		SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		String now = data.format(date);

		if (time.toString().compareTo(now) > 0) {
			return true;
		} else {
			return false;
		}
	}

}
