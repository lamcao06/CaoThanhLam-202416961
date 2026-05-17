package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;

import java.util.*;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Books
        store.addMedia(new Book("Harry Potter", "Adventure", 18.5f));
        store.addMedia(new Book("Clean Code", "Technology", 42.0f));
        store.addMedia(new Book("Linear Algebra", "Education",
                22.5f, List.of("David Lay", "Steven Leon")));

        // DVDs
        store.addMedia(new DigitalVideoDisc(
                "Avengers Endgame",
                "Action",
                "Anthony Russo",
                181,
                35.0f));

        store.addMedia(new DigitalVideoDisc(
                "Interstellar",
                "Science Fiction",
                "Christopher Nolan",
                169));

        // Compact Disc 1
        CompactDisc cd1 = new CompactDisc(
                "Midnights",
                "Pop",
                1250.5f,
                "Taylor Swift");

        Track t1 = new Track("Lavender Haze", 202);
        Track t2 = new Track("Anti-Hero", 201);
        Track t3 = new Track("Snow On The Beach", 256);

        cd1.addTrack(t1);
        cd1.addTrack(t2);
        cd1.addTrack(t3);

        // Compact Disc 2
        CompactDisc cd2 = new CompactDisc(
                "Divide",
                "Pop",
                980.0f,
                "Ed Sheeran");

        Track t4 = new Track("Shape of You", 233);
        Track t5 = new Track("Perfect", 263);
        Track t6 = new Track("Galway Girl", 170);

        cd2.addTrack(t4);
        cd2.addTrack(t5);
        cd2.addTrack(t6);

        // Compact Disc 3
        CompactDisc cd3 = new CompactDisc(
                "Future Nostalgia",
                "Dance Pop",
                1100.75f,
                "Dua Lipa");

        Track t7 = new Track("Levitating", 203);
        Track t8 = new Track("Hallucinate", 208);

        cd3.addTrack(t7);
        cd3.addTrack(t8);

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);

        int choice;

        do {
            showMenu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    viewStore();
                    break;

                case 2:
                    updateStore();
                    break;

                case 3:
                    viewCart();
                    break;

                case 0:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid option!");
            }

        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("===== AIMS APPLICATION =====");
        System.out.println("1. Browse store");
        System.out.println("2. Manage store");
        System.out.println("3. View shopping cart");
        System.out.println("0. Quit");
        System.out.print("Select your option: ");
    }

    public static void viewStore() {
        store.printStore();

        int choice;

        do {
            storeMenu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;

                case 2:
                    addMediaToCart();
                    break;

                case 3:
                    playMedia();
                    break;

                case 4:
                    viewCart();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid option!");
            }

        } while (true);
    }

    public static void storeMenu() {
        System.out.println("\n===== STORE MENU =====");
        System.out.println("1. Display media details");
        System.out.println("2. Add media to cart");
        System.out.println("3. Play selected media");
        System.out.println("4. Open cart");
        System.out.println("0. Return");
        System.out.print("Your choice: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\n===== MEDIA DETAILS =====");
        System.out.println("1. Add this media to cart");
        System.out.println("2. Play this media");
        System.out.println("0. Return");
        System.out.print("Choose: ");
    }

    public static void seeMediaDetails() {
        System.out.print("Enter media title: ");

        String title = sc.nextLine();

        Media m = store.searchByTitle(title);

        if (m == null) {
            System.out.println("Cannot find media.");
            return;
        }

        System.out.println(m);

        int choice;

        do {
            mediaDetailsMenu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    cart.addMedia(m);
                    System.out.println("Item added successfully.");
                    break;

                case 2:
                    if (m instanceof Playable)
                        ((Playable) m).play();
                    else
                        System.out.println("This item is not playable.");
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid option!");
            }

        } while (true);
    }

    public static void addMediaToCart() {
        System.out.print("Input media title to add: ");

        String title = sc.nextLine();

        Media m = store.searchByTitle(title);

        if (m == null) {
            System.out.println("Media does not exist.");
            return;
        }

        cart.addMedia(m);

        System.out.println("Added successfully.");
        System.out.println("Current number of items: "
                + cart.getItems().size());
    }

    public static void playMedia() {
        System.out.print("Enter media title to play: ");

        String title = sc.nextLine();

        Media m = store.searchByTitle(title);

        if (m == null) {
            System.out.println("Media not found.");
            return;
        }

        if (m instanceof Playable)
            ((Playable) m).play();
        else
            System.out.println("This media cannot be played.");
    }

    public static void updateStore() {

        System.out.println("1. Insert media");
        System.out.println("2. Delete media");

        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {

            case 1:

                System.out.println("Choose media type:");
                System.out.println("1. Book");
                System.out.println("2. DVD");
                System.out.println("3. CD");

                int type = Integer.parseInt(sc.nextLine());

                System.out.print("Title: ");
                String title = sc.nextLine();

                System.out.print("Category: ");
                String category = sc.nextLine();

                System.out.print("Cost: ");
                float cost = Float.parseFloat(sc.nextLine());

                Media media = null;

                switch (type) {

                    case 1:
                        media = new Book(title, category, cost);
                        break;

                    case 2:
                        System.out.print("Director: ");
                        String director = sc.nextLine();

                        System.out.print("Length: ");
                        int length = Integer.parseInt(sc.nextLine());

                        media = new DigitalVideoDisc(
                                title,
                                category,
                                director,
                                length,
                                cost);

                        break;

                    case 3:
                        System.out.print("Artist: ");
                        String artist = sc.nextLine();

                        media = new CompactDisc(
                                title,
                                category,
                                cost,
                                artist);

                        break;

                    default:
                        System.out.println("Invalid media type.");
                }

                if (media != null) {
                    store.addMedia(media);
                    System.out.println("Media inserted.");
                }

                break;

            case 2:

                System.out.print("Enter title to delete: ");

                String t = sc.nextLine();

                Media m = store.searchByTitle(t);

                if (m != null) {
                    store.removeMedia(m);
                    System.out.println("Media removed.");
                } else {
                    System.out.println("Cannot find media.");
                }

                break;

            default:
                System.out.println("Invalid option.");
        }
    }

    public static void viewCart() {

        cart.printCart();

        int choice;

        do {

            cartMenu();

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:

                    System.out.println("Search by:");
                    System.out.println("1. ID");
                    System.out.println("2. Title");

                    int f = Integer.parseInt(sc.nextLine());

                    if (f == 1) {

                        System.out.print("Enter id: ");

                        int id = Integer.parseInt(sc.nextLine());

                        cart.getItems().stream()
                                .filter(m -> m.getId() == id)
                                .forEach(System.out::println);

                    } else if (f == 2) {

                        System.out.print("Enter title: ");

                        String title = sc.nextLine();

                        cart.getItems().stream()
                                .filter(m -> m.getTitle()
                                        .equalsIgnoreCase(title))
                                .forEach(System.out::println);
                    }

                    break;

                case 2:

                    System.out.println("Sort options:");
                    System.out.println("1. Cost then title");
                    System.out.println("2. Title then cost");

                    int s = Integer.parseInt(sc.nextLine());

                    if (s == 1) {
                        cart.getItems().sort(
                                new MediaComparatorByCostTitle());
                    } else if (s == 2) {
                        cart.getItems().sort(
                                new MediaComparatorByTitleCost());
                    }

                    System.out.println("Cart sorted successfully.");

                    cart.getItems().forEach(System.out::println);

                    break;

                case 3:

                    System.out.print("Title to remove: ");

                    String removeTitle = sc.nextLine();

                    for (Media m : cart.getItems()) {

                        if (m.getTitle()
                                .equalsIgnoreCase(removeTitle)) {

                            cart.removeMedia(m);
                            System.out.println("Removed successfully.");
                            break;
                        }
                    }

                    break;

                case 4:

                    System.out.print("Enter media title to play: ");

                    String playTitle = sc.nextLine();

                    Media mediaToPlay = null;

                    for (Media m : cart.getItems()) {

                        if (m.getTitle()
                                .equalsIgnoreCase(playTitle)) {

                            mediaToPlay = m;
                            break;
                        }
                    }

                    if (mediaToPlay == null) {

                        System.out.println("Cannot find media.");

                    } else if (mediaToPlay instanceof Playable) {

                        ((Playable) mediaToPlay).play();

                    } else {

                        System.out.println("Media is not playable.");
                    }

                    break;

                case 5:

                    System.out.println("Thank you for your purchase!");
                    System.out.println("Your order has been created.");

                    cart.clear();

                    return;

                case 0:
                    return;

                default:
                    System.out.println("Invalid option.");
            }

        } while (true);
    }

    public static void cartMenu() {

        System.out.println("\n===== CART MENU =====");
        System.out.println("1. Search media in cart");
        System.out.println("2. Sort cart");
        System.out.println("3. Remove media");
        System.out.println("4. Play media");
        System.out.println("5. Checkout");
        System.out.println("0. Return");

        System.out.print("Select: ");
    }
}