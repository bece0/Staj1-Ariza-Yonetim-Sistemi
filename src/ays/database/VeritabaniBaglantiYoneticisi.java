/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ays.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author test
 */
public class VeritabaniBaglantiYoneticisi {

    private static Connection baglanti = null;

    public static Connection getConnection() {

        if (baglanti != null) {
            return baglanti;
        }

        try {
            Class.forName("org.postgresql.Driver");

            String veritabaniAdi = "deneme";
            String veritabaniKullaniciAdi = "postgres";
            String veritabaniKullaniciParola = "postgres";

            baglanti = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/" + veritabaniAdi, veritabaniKullaniciAdi, veritabaniKullaniciParola);

            System.out.println("Baglandi ");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Baglanti hatasi !");
            System.out.println(e.getMessage());
        }
        return baglanti;
    }

}
