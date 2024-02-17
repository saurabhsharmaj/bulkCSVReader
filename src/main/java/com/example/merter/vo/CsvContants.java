package com.example.merter.vo;

public class CsvContants {

	public final static String CSV_FILE_NAME="meter_values_dump_10k.csv";
	public final static int CHUNK_SIZE=100;
	public static final String READ_INPROGESS = "inprogress";
	public static final String READ_COMPLETED = "completed";
	public static final int MAX_QUEUE_CAPACITY = 100;
	public static final int PRODUCER_COUNT = 1;
	public static final int CONSUMER_COUNT = 1;
}
