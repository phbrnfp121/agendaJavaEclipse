package outils;

import java.io.*;

public class IN {

 public static String getString() {
  BufferedReader fe = new BufferedReader(new InputStreamReader(System.in));
  boolean erreur;
  String lu = null;
  do {
    try {
      erreur = false;
      lu = fe.readLine();
    }
    catch (IOException e) {
      System.out.println("Recommencez.");
      erreur = true;
    }
  } while (erreur);
  return lu;
 }

 public static char getChar() {
  String lu;
  boolean erreur;
  do {
    lu = getString();
    erreur = lu.equals("");
  } while (erreur);
  return lu.charAt(0);
 }

 public static int getInt() {
  boolean erreur;
  int lu = 0;
  do {
    try {
      erreur = false;
      lu = Integer.parseInt(getString());
    }
    catch (NumberFormatException e) {
      System.out.println("Veuillez entrer un entier!");
      erreur = true;
    }
  } while (erreur);
  return lu;
 }

 public static double getDouble() {
  boolean erreur;
  double lu = 0;
  do {
    try {
      erreur = false;
      lu = Double.parseDouble(getString());
    }
    catch (NumberFormatException e) {
      System.out.println("Veuillez entrer un flottant!");
      erreur = true;
    }
  } while (erreur);
  return lu;
 }

 public static float getFloat() {
  return (float)getDouble();
 }
}