package hussain.shahzad.java.utils;

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

import hussain.shahzad.java.constants.Constants;

public class DateUtil extends Constants {

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

	public static Date getDateBeforeXDays(Date date, String pattern, int dateBeforeXDays) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, -dateBeforeXDays);
		return sdf.parse(sdf.format(c.getTime()));
	}

	public static Date getDateAfterXDays(Date date, String pattern, int dateAfterXDays) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, dateAfterXDays);
		return sdf.parse(sdf.format(c.getTime()));
	}

	public static int periodDifferenceInMonths(String startDate, String endDate) {
		Period between = Period.between(LocalDate.parse(startDate), LocalDate.parse(endDate));
		return between.getMonths();
	}

	public static long localDateDifferenceInMonths(String startDate, String endDate) {
		return ChronoUnit.MONTHS.between(LocalDate.parse(startDate), LocalDate.parse(endDate));
	}

	public static long localDateDifferenceInMonths(LocalDate startDate, LocalDate endDate) {
		return ChronoUnit.MONTHS.between(startDate, endDate);
	}

	public static Date getLocalDateToDate(LocalDate localDate) throws ParseException {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public static LocalDate getLocalDateFromDate(Date date) throws ParseException {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault()).toLocalDate();
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
		return getLocalDateToDate(firstDayOfNextMonth);
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

	public static List<LocalDate> getDateRange(Date startDate, Date endDate) throws ParseException {
		LocalDate start = getLocalDateFromDate(startDate);
		LocalDate end = getLocalDateFromDate(endDate);
		List<LocalDate> totalDates = new ArrayList<>();
		while (!start.isAfter(end)) {
			totalDates.add(start);
			start = start.plusDays(1);
		}
		return totalDates;
	}

	public static Date instantToDate(Instant instant) {
		return Date.from(instant);
	}

	public static String getDateFromInstant(Instant instantDate, String format) {
		LocalDateTime datetime = LocalDateTime.ofInstant(instantDate, ZoneOffset.UTC);
		return DateTimeFormatter.ofPattern(format).format(datetime);
	}

	public static long daysBetweenDates(Date d1, Date d2) {
		Instant instant1 = d1.toInstant();
		Instant instant2 = d2.toInstant();
		long diff = ChronoUnit.DAYS.between(instant1, instant2);
		return diff;
	}

	public static void main(String[] args) throws ParseException {
		System.out.println(format(getDateBeforeXDays(new Date(), DD_MM_YYYY, 60), DD_MM_YYYY));
	}
}
