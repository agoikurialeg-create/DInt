package com.mycompany.dint10.sudoku;

import Model.Gelaxka;
import Model.SudokuMaila;
import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 * Sudokuaren kontrolatzailea
 * JSON fitxategitik datuak kargatu eta pantailaratzeaz arduratzen da.
 */
public class PrimaryController implements Initializable {

    // FXML bidez lotutako elementuak
    @FXML private GridPane gridBase;
    @FXML private GridPane bl1;
    @FXML private GridPane bl2;
    @FXML private GridPane bl3;
    @FXML private GridPane bl4;
    @FXML private GridPane bl5;
    @FXML private GridPane bl6;
    @FXML private GridPane bl7;
    @FXML private GridPane bl8;
    @FXML private GridPane bl9;

    @FXML private Button btnAldatu;
    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private Button btn3;
    @FXML private Button btn4;
    @FXML private Button btn5;
    @FXML private Button btn6;
    @FXML private Button btn7;
    @FXML private Button btn8;
    @FXML private Button btn9;

    // Datu egiturak
    private List<SudokuMaila> mailak;               // JSONetik kargatutako mailak
    private List<Gelaxka> gelaxkak;                 // Uneko mailako gelaxkak
    private final List<Label> etiketaZerrenda = new ArrayList<>(81);
    private Label hautatua = null;                  // Unean hautatutako gelaxkaren Label-a
    private int unekoMaila = 0;                     // Zein maila dagoen pantailan

    // Zenbakien kontrol osagarria
    private final Map<String,Integer> faltaZenbakiak = new HashMap<>();  // "1".."9" zenbat falta diren
    private final Map<String,Button>  botoiMapa       = new HashMap<>();  // "1".."9" -> Button

    // Hasieratzean exekutatzen den metodoa
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Zenbaki-botoien mapa prestatu
        botoiMapa.put("1", btn1); botoiMapa.put("2", btn2); botoiMapa.put("3", btn3);
        botoiMapa.put("4", btn4); botoiMapa.put("5", btn5); botoiMapa.put("6", btn6);
        botoiMapa.put("7", btn7); botoiMapa.put("8", btn8); botoiMapa.put("9", btn9);

        kargatuJson();                                   // JSON fitxategia kargatu
        if (mailak != null && !mailak.isEmpty()) {
            erakutsiMaila(mailak.get(unekoMaila));       // Lehenengo maila erakutsi
        } else {
            System.err.println("Ez dago mailarik kargatuta.");
        }
    }

    // Bloke guztiak taula batean itzultzen ditu
    private GridPane[] blokeak() {
        return new GridPane[]{bl1, bl2, bl3, bl4, bl5, bl6, bl7, bl8, bl9};
    }

    // JSON fitxategia kargatu eta "mailak" aldagaian gorde
    private void kargatuJson() {
        try (InputStream is = getClass().getResourceAsStream("/json/sudoku.json")) {

            if (is == null) {
                System.err.println("Fitxategia ez da aurkitu: /json/sudoku.json");
                return;
            }

            InputStreamReader r = new InputStreamReader(is, StandardCharsets.UTF_8);
            Type t = new TypeToken<List<SudokuMaila>>(){}.getType();
            mailak = new Gson().fromJson(r, t);

            System.out.println("Mailak ondo kargatu dira: " + mailak.size());

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Errorea: ezin izan da JSON fitxategia irakurri.");
        }
    }

    // Uneko maila pantailan erakusten du
    private void erakutsiMaila(SudokuMaila maila) {
        // Garbitu azpitaulak eta egoera
        for (GridPane b : blokeak()) b.getChildren().clear();
        etiketaZerrenda.clear();
        hautatua = null;

        gelaxkak = maila.getSudoku();
        GridPane[] bl = blokeak();

        // Hasierako kontaketak prestatu eta botoiak eguneratu
        eguneratuKontaketakHasieratik();
        eguneratuBotoiak();

        // 81 gelaxkak sortu eta kokatu
        for (int i = 0; i < 81; i++) {
            Gelaxka g = gelaxkak.get(i);
            Label lbl = new Label();
            lbl.getStyleClass().removeAll("emanda", "erabiltzaileak", "zuzena", "okerra", "hautatua");

            if ("IKUSI".equals(g.getEgoera())) {
                // Emana: testua jarri, negrita CSS bidez, eta blokeatu
                lbl.setText(g.getBalorea());
                lbl.getStyleClass().add("emanda");
                lbl.setMouseTransparent(true);
            } else {
                // Erabiltzaileak betetzeko
                lbl.setText("");
                lbl.getStyleClass().add("erabiltzaileak");
                lbl.setMouseTransparent(false);
            }

            // Kokalekua kalkulatu
            int r = i / 9, c = i % 9;
            int blok = (r / 3) * 3 + (c / 3);
            int barneR = r % 3, barneC = c % 3;

            lbl.setPrefSize(40, 40);
            lbl.setAlignment(javafx.geometry.Pos.CENTER);

            bl[blok].add(lbl, barneC, barneR);
            etiketaZerrenda.add(lbl);
        }
    }

    // Hasierako zenbakien falta kopurua kalkulatu (soluzioa - IKUSI hasieratik)
    private void eguneratuKontaketakHasieratik() {
        faltaZenbakiak.clear();
        for (int z = 1; z <= 9; z++) faltaZenbakiak.put(String.valueOf(z), 0);

        // Guztira (soluzioaren arabera) — normala 9 bana izatea
        Map<String,Integer> guztira = new HashMap<>();
        for (int z = 1; z <= 9; z++) guztira.put(String.valueOf(z), 0);
        for (Gelaxka g : gelaxkak) {
            String v = g.getBalorea();
            guztira.put(v, guztira.get(v) + 1);
        }

        // Hasierako ikusgai daudenak (IKUSI)
        Map<String,Integer> ikusgai = new HashMap<>();
        for (int z = 1; z <= 9; z++) ikusgai.put(String.valueOf(z), 0);
        for (Gelaxka g : gelaxkak) {
            if ("IKUSI".equals(g.getEgoera())) {
                String v = g.getBalorea();
                ikusgai.put(v, ikusgai.get(v) + 1);
            }
        }

        // Falta direnen kalkulua
        for (int z = 1; z <= 9; z++) {
            String k = String.valueOf(z);
            faltaZenbakiak.put(k, guztira.get(k) - ikusgai.get(k));
        }
    }

    // Botoien egoera eguneratu: 0 -> desgaitu (gris CSS bidez)
    private void eguneratuBotoiak() {
        for (int z = 1; z <= 9; z++) {
            String k = String.valueOf(z);
            Button b = botoiMapa.get(k);
            if (b != null) {
                boolean desgaituta = faltaZenbakiak.getOrDefault(k, 0) <= 0;
                b.setDisable(desgaituta);
            }
        }
    }

    // Gelaxka batean klik egitean
    @FXML
    private void gelaxkaKlik(MouseEvent e) {
        Node t = (Node) e.getTarget();
        Label lbl = null;
        while (t != null && lbl == null) {
            if (t instanceof Label) lbl = (Label) t;
            else t = t.getParent();
        }
        if (lbl == null) return;

        // Emandakoei edo dagoeneko zuzen blokeatuei ez utzi hautatzen
        if (lbl.getStyleClass().contains("emanda")) return;
        if (lbl.getStyleClass().contains("zuzena")) return;
        if (lbl.isMouseTransparent()) return;

        if (hautatua != null) hautatua.getStyleClass().remove("hautatua");
        hautatua = lbl;
        lbl.getStyleClass().add("hautatua");
    }

    // Zenbaki botoietan klik egitean
    @FXML
    private void zenbakiKlik(MouseEvent e) {
        if (hautatua == null) return;

        Button b = (Button) e.getSource();
        String zenb = b.getText();

        // Posizio osoa kalkulatu (bloke + barne posizioa -> 0..80)
        Integer fila = GridPane.getRowIndex(hautatua);
        Integer col  = GridPane.getColumnIndex(hautatua);
        int r = (fila == null) ? 0 : fila;
        int c = (col  == null) ? 0 : col;

        GridPane parent = (GridPane) hautatua.getParent();
        int blokIndex = Arrays.asList(blokeak()).indexOf(parent);
        int pos = (blokIndex / 3) * 27 + (blokIndex % 3) * 3 + r * 9 + c;

        Gelaxka g = gelaxkak.get(pos);

        // Egoera bisuala garbitu
        hautatua.getStyleClass().removeAll("zuzena", "okerra", "hautatua");
        hautatua.setText(zenb);

        if (zenb.equals(g.getBalorea())) {
            // Zuzena: markatu, blokeatu gelaxka eta eguneratu botoiak
            hautatua.getStyleClass().add("zuzena");
            hautatua.setMouseTransparent(true);   // ezin da berriro aldatu
            // Zenbaki honetatik falta direnak murriztu
            faltaZenbakiak.put(zenb, faltaZenbakiak.getOrDefault(zenb, 0) - 1);
            eguneratuBotoiak();
            // Hautapena kendu
            hautatua = null;
        } else {
            // Okerra: markatu, baina utzi erabiltzaileari aldatzen
            hautatua.getStyleClass().add("okerra");
            // Hautatuta mantentzen dugu, nahi badu berehala beste zenbaki bat probatzeko
        }
    }

    // Maila aldatzeko botoia sakatzean
    @FXML
    private void aldatuSudokua() {
        if (mailak == null || mailak.isEmpty()) return;
        unekoMaila = (unekoMaila + 1) % mailak.size();
        erakutsiMaila(mailak.get(unekoMaila));
    }
}
