package com.github.affandes.kuliah.pm;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        Stack<String> history = new Stack<>();

        System.out.println("=== Browser History Simulator ===");
        System.out.println("Commands: browse <url>, back, view, exit");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            // VIEW HISTORY
            else if (input.equalsIgnoreCase("view")) {
                if (history.isEmpty()) {
                    System.out.println("History kosong.");
                } else {
                    System.out.println("=== Browser History (paling baru) ===");
                    for (int i = history.size() - 1; i >= 0; i--) {
                        System.out.println(history.get(i));
                    }
                }
            }

            // BACK (POP)
            else if (input.equalsIgnoreCase("back")) {
                if (history.isEmpty()) {
                    System.out.println("Tidak ada history untuk kembali.");
                } else {
                    String removed = history.pop();
                    System.out.println("Kembali dari: " + removed);

                    if (!history.isEmpty()) {
                        System.out.println("Sekarang berada di: " + history.peek());
                    } else {
                        System.out.println("Tidak ada halaman sebelumnya.");
                    }
                }
            }

            // BROWSE NEW URL
            else if (input.toLowerCase().startsWith("browse ")) {
                String newUrl = input.substring(7).trim();
                if (newUrl.isEmpty()) {
                    System.out.println("URL tidak boleh kosong.");
                } else {
                    history.push(newUrl);
                    System.out.println("Browsing: " + newUrl);
                }
            }

            // COMMAND UNKNOWN
            else {
                System.out.println("Perintah tidak dikenal. Gunakan: browse <url>, back, view, exit");
            }
        }

        scanner.close();

    }
}
