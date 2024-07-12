package com.cetin.proxy;

public class Main {
	public static void main(String[] args) {
		GercekBasbakan gercekBasbakan = new GercekBasbakan();
		BasbakanlikKalemi basbakanlikKalemi = new BasbakanlikKalemi(gercekBasbakan);
		Vatandas vatandas = new Vatandas(basbakanlikKalemi);
		vatandas.dertAnlat();
	}
}
