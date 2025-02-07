package util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatadorUtil {
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("pt").setRegion("BR").build());

	public static String formatarData(LocalDate data) {
		return data.format(DATE_FORMAT);
	}

	public static String formatarMoeda(BigDecimal valor) {
		return CURRENCY_FORMAT.format(valor);
	}
}
	