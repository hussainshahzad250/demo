package hussain.shahzad.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

	public static final String HH_MM = "HH:mm";
	public static final String YYYY_MM = "yyyy-MM";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String DD_MM_YYYY = "dd-MM-yyyy";

	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String DD_MM_YYYY_HH_MM_SS = "dd-MM-yyyy HH:mm:ss";

	public static List<LocalDate> getDateRange(Date startDate, Date endDate) throws ParseException {
		System.out.println("From " + startDate + "\nToDate" + endDate);
		LocalDate start = getLocalDateFromDate(startDate);
		LocalDate end = getLocalDateFromDate(endDate);
		List<LocalDate> totalDates = new ArrayList<>();
		while (!start.isAfter(end)) {
			totalDates.add(start);
			start = start.plusDays(1);
		}
		return totalDates;
	}

	public static Date parseDate(String date, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setLenient(false);
		return sdf.parse(date);
	}

	public static String format(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static Date getDateFromMillis(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

	public static Date getDateBeforeXDays(Date date, int numberOfDays) throws ParseException {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, -numberOfDays);
		return c.getTime();
	}

	public static Date getDateAfterXDays(Date date, int numberOfDays) throws ParseException {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, numberOfDays);
		return c.getTime();
	}

	public static int periodDifference(String startDate, String endDate) {
		Period between = Period.between(LocalDate.parse(startDate), LocalDate.parse(endDate));
		return between.getMonths();
	}

	public static long localDateDifference(String startDate, String endDate) {
		return ChronoUnit.MONTHS.between(LocalDate.parse(startDate), LocalDate.parse(endDate));
	}

	public static long localDateDifference(LocalDate startDate, LocalDate endDate) {
		return ChronoUnit.MONTHS.between(startDate, endDate);
	}

	public static Date localDateToDate(LocalDate localDate) throws ParseException {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public static LocalDate getFirstDayOfNextMonth(LocalDate localDate) {
		return localDate.with(TemporalAdjusters.firstDayOfNextMonth());
	}

	public static LocalDate getFirstDayOfMonth(LocalDate localDate) {
		return localDate.with(TemporalAdjusters.firstDayOfMonth());
	}

	public static Date getNextMonthFirstDayFromDate(Date date) throws ParseException {
		LocalDate dateToLocalDate = getLocalDateFromDate(date);
		LocalDate firstDayOfNextMonth = getFirstDayOfNextMonth(dateToLocalDate);
		return localDateToDate(firstDayOfNextMonth);
	}

	public static Date getLastDateOfMonth(Date date) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		Date lastDayOfMonth = calendar.getTime();
		return lastDayOfMonth;
	}

	public static List<LocalDate> getDateRange(String startDate, String endDate) {
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);
		List<LocalDate> totalDates = new ArrayList<>();
		while (!start.isAfter(end)) {
			totalDates.add(start);
			start = start.plusDays(1);
		}
		return totalDates;
	}

	public static Date getDateFromInstant(Instant instant) {
		return Date.from(instant);
	}

	public static LocalDate getLocalDateFromInstant(Instant instant) throws ParseException {
		return getLocalDateFromDate(Date.from(instant));
	}

	public static String getDateFromInstant(Instant instantDate, String format) {
		LocalDateTime datetime = LocalDateTime.ofInstant(instantDate, ZoneOffset.UTC);
		return DateTimeFormatter.ofPattern(format).format(datetime);
	}

	public static Instant getInstantFromString(String date, String format) throws ParseException {
		return parseDate(date, format).toInstant();
	}

	public static Instant getInstantFromLocalDate(LocalDate date) {
		return Instant.from(date);
	}

	public static long daysBetweenDates(Date d1, Date d2) {
		Instant instant1 = d1.toInstant();
		Instant instant2 = d2.toInstant();
		long diff = ChronoUnit.DAYS.between(instant1, instant2);
		return diff;
	}

	public static String getLocalDateToString(LocalDate localDate, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return localDate.format(formatter);
	}

	public static LocalDate getNextMonth(LocalDate localDate) {
		if (localDate == null)
			return null;
		return localDate.plusMonths(1);
	}

	public static LocalDate getLocalDateFromDate(Date date) throws ParseException {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault()).toLocalDate();
	}

	public static long getTotalDaysFromDateDifference(Date fromDate, Date toDate) throws ParseException {
		LocalDate localDateFromDate = getLocalDateFromDate(toDate);
		LocalDate localDateFromDate2 = getLocalDateFromDate(fromDate);
		return ChronoUnit.DAYS.between(localDateFromDate2, localDateFromDate) + 1;
	}

	public static void main(String[] args) throws ParseException {
		System.out.println(getDateBeforeXDays(new Date(), 60));
	}
}
