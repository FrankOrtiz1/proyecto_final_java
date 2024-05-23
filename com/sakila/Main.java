package com.sakila;

import com.sakila.controllers.*;
import com.sakila.models.*;
import com.sakila.reports.ReportGenerator;

import java.sql.Date;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static FilmController filmController = new FilmController();
    private static ActorController actorController = new ActorController();
    private static CustomerController customerController = new CustomerController();
    private static RentalController rentalController = new RentalController();
    private static ReportGenerator reportGenerator = new ReportGenerator(filmController);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Sistema de Gestion Sakila");
            System.out.println("1. Gestion de Peliculas");
            System.out.println("2. Gestion de Actores");
            System.out.println("3. Gestion de Clientes");
            System.out.println("4. Gestion de Rentas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (choice) {
                case 1:
                    filmMenu(scanner);
                    break;
                case 2:
                    actorMenu(scanner);
                    break;
                case 3:
                    customerMenu(scanner);
                    break;
                case 4:
                    rentalMenu(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void filmMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("Gestion de Peliculas");
            System.out.println("1. Crear Pelicula");
            System.out.println("2. Leer Pelicula");
            System.out.println("3. Actualizar Pelicula");
            System.out.println("4. Eliminar Pelicula");
            System.out.println("5. Listar Peliculas");
            System.out.println("6. Generar Reporte de Peliculas");
            System.out.println("7. Volver al Menu Principal");
            System.out.print("Seleccione una opcion: ");
            choice = scanner.nextInt();
            scanner.nextLine();   

            switch (choice) {
                case 1:
                    createFilm(scanner);
                    break;
                case 2:
                    readFilm(scanner);
                    break;
                case 3:
                    updateFilm(scanner);
                    break;
                case 4:
                    deleteFilm(scanner);
                    break;
                case 5:
                    listFilms();
                    break;
                case 6:
                    generateFilmReport();
                    break;
                case 7:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (choice != 7);
    }

    private static void actorMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("Gestion de Actores");
            System.out.println("1. Crear Actor");
            System.out.println("2. Leer Actor");
            System.out.println("3. Actualizar Actor");
            System.out.println("4. Eliminar Actor");
            System.out.println("5. Listar Actores");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            choice = scanner.nextInt();
            scanner.nextLine();   

            switch (choice) {
                case 1:
                    createActor(scanner);
                    break;
                case 2:
                    readActor(scanner);
                    break;
                case 3:
                    updateActor(scanner);
                    break;
                case 4:
                    deleteActor(scanner);
                    break;
                case 5:
                    listActors();
                    break;
                case 6:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opcion no válida.");
            }
        } while (choice != 6);
    }

    private static void customerMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("Gestion de Clientes");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Leer Cliente");
            System.out.println("3. Actualizar Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("5. Listar Clientes");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (choice) {
                case 1:
                    createCustomer(scanner);
                    break;
                case 2:
                    readCustomer(scanner);
                    break;
                case 3:
                    updateCustomer(scanner);
                    break;
                case 4:
                    deleteCustomer(scanner);
                    break;
                case 5:
                    listCustomers();
                    break;
                case 6:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opcion no válida.");
            }
        } while (choice != 6);
    }

    private static void rentalMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("Gestion de Rentas");
            System.out.println("1. Crear Renta");
            System.out.println("2. Leer Renta");
            System.out.println("3. Actualizar Renta");
            System.out.println("4. Eliminar Renta");
            System.out.println("5. Listar Rentas");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            choice = scanner.nextInt();
            scanner.nextLine();   

            switch (choice) {
                case 1:
                    createRental(scanner);
                    break;
                case 2:
                    readRental(scanner);
                    break;
                case 3:
                    updateRental(scanner);
                    break;
                case 4:
                    deleteRental(scanner);
                    break;
                case 5:
                    listRentals();
                    break;
                case 6:
                    System.out.println("Volviendo al Menu Principal...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (choice != 6);
    }

    // Métodos para gestionar Películas
    private static void createFilm(Scanner scanner) {
        System.out.print("Ingrese el ID de la pelicula: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el titulo de la pelicula: ");
        String title = scanner.nextLine();
        System.out.print("Ingrese la descripciin de la pelicula: ");
        String description = scanner.nextLine();
        System.out.print("Ingrese el anio de lanzamiento: ");
        int releaseYear = scanner.nextInt();
        System.out.print("Ingrese el ID del lenguaje: ");
        int languageId = scanner.nextInt();

        Film film = new Film(id, title, description, releaseYear, languageId);
        filmController.createFilm(film);
        System.out.println("Pelicula creada exitosamente.");
    }

    private static void readFilm(Scanner scanner) {
        System.out.print("Ingrese el ID de la pelicula: ");
        int id = scanner.nextInt();
        Film film = filmController.readFilm(id);
        if (film != null) {
            System.out.println("ID: " + film.getId());
            System.out.println("Titulo: " + film.getTitle());
            System.out.println("Descripcion: " + film.getDescription());
            System.out.println("Anio de lanzamiento: " + film.getReleaseYear());
            System.out.println("ID del lenguaje: " + film.getLanguage());
        } else {
            System.out.println("Pelicula no encontrada.");
        }
    }

    private static void updateFilm(Scanner scanner) {
        System.out.print("Ingrese el ID de la pelicula a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nuevo titulo de la pelicula: ");
        String title = scanner.nextLine();
        System.out.print("Ingrese la nueva descripcion de la pelicula: ");
        String description = scanner.nextLine();
        System.out.print("Ingrese el nuevo anio de lanzamiento: ");
        int releaseYear = scanner.nextInt();
        System.out.print("Ingrese el nuevo ID del lenguaje: ");
        int languageId = scanner.nextInt();

        Film film = new Film(id, title, description, releaseYear, languageId);
        filmController.updateFilm(film);
        System.out.println("Pelicula actualizada exitosamente.");
    }

    private static void deleteFilm(Scanner scanner) {
        System.out.print("Ingrese el ID de la pelicula a eliminar: ");
        int id = scanner.nextInt();
        filmController.deleteFilm(id);
        System.out.println("Pelicula eliminada exitosamente.");
    }

    private static void listFilms() {
        filmController.listFilms().forEach((id, film) -> {
            System.out.println("ID: " + film.getId() + ", Titulo: " + film.getTitle() +
                    ", Descripcion: " + film.getDescription() + ", Anio: " + film.getReleaseYear());
        });
    }

    private static void generateFilmReport() {
        reportGenerator.generateFilmReport();
        System.out.println("Reporte de peliculas generado exitosamente.");
    }

    // Métodos para gestionar Actores
    private static void createActor(Scanner scanner) {
        System.out.print("Ingrese el ID del actor: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nombre del actor: ");
        String firstName = scanner.nextLine();
        System.out.print("Ingrese el apellido del actor: ");
        String lastName = scanner.nextLine();

        Actor actor = new Actor(id, firstName, lastName);
        actorController.createActor(actor);
        System.out.println("Actor creado exitosamente.");
    }

    private static void readActor(Scanner scanner) {
        System.out.print("Ingrese el ID del actor: ");
        int id = scanner.nextInt();
        Actor actor = actorController.readActor(id);
        if (actor != null) {
            System.out.println("ID: " + actor.getId());
            System.out.println("Nombre: " + actor.getFirstName());
            System.out.println("Apellido: " + actor.getLastName());
        } else {
            System.out.println("Actor no encontrado.");
        }
    }

    private static void updateActor(Scanner scanner) {
        System.out.print("Ingrese el ID del actor a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nuevo nombre del actor: ");
        String firstName = scanner.nextLine();
        System.out.print("Ingrese el nuevo apellido del actor: ");
        String lastName = scanner.nextLine();

        Actor actor = new Actor(id, firstName, lastName);
        actorController.updateActor(actor);
        System.out.println("Actor actualizado exitosamente.");
    }

    private static void deleteActor(Scanner scanner) {
        System.out.print("Ingrese el ID del actor a eliminar: ");
        int id = scanner.nextInt();
        actorController.deleteActor(id);
        System.out.println("Actor eliminado exitosamente.");
    }

    private static void listActors() {
        actorController.listActors().forEach((id, actor) -> {
            System.out.println("ID: " + actor.getId() + ", Nombre: " + actor.getFirstName() +
                    ", Apellido: " + actor.getLastName());
        });
    }

    // Métodos para gestionar Clientes
    private static void createCustomer(Scanner scanner) {
        System.out.print("Ingrese el ID del cliente: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese el ID de la tienda: ");
        int storeid = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nombre del cliente: ");
        String firstName = scanner.nextLine();
        System.out.print("Ingrese el apellido del cliente: ");
        String lastName = scanner.nextLine();
        System.out.print("Ingrese id de la  direccion: ");
        int direccion = scanner.nextInt();
        System.out.print("Ingrese fecha (formato YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();

        // Parse date using java.time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date fecha = (Date) formatter.parse(fechaStr);

        Customer customer = new Customer(id,storeid, firstName,  lastName, direccion,  fecha);
        try{

            customerController.createCustomer(customer);
            System.out.println("Cliente creado exitosamente.");
        }catch (SQLException e) {
            System.err.println("Error al actualizar cliente: " + e.getMessage());
        }
    }
       
    

    private static void readCustomer(Scanner scanner) {
        System.out.print("Ingrese el ID del cliente: ");
        int id = scanner.nextInt();
        try{
            Customer customer = customerController.readCustomer(id);
        if (customer != null) {
            System.out.println("ID: " + customer.getCustomerId());
            System.out.println("ID Tienda: " + customer.getStoreId());
            System.out.println("Nombre: " + customer.getFirstName());
            System.out.println("Apellido: " + customer.getLastName());
            System.out.println("Id Direccion: " + customer.getAddressId());
            System.out.println("Fecha de creacion: " + customer.getCreateDate());
        } else {
            System.out.println("Cliente no encontrado.");
        }

        }catch(SQLException e)
        {
            System.err.println("Error al actualizar cliente: " + e.getMessage());
        }
        
    }

    private static void updateCustomer(Scanner scanner) {
        System.out.print("Ingrese el ID del cliente a actualizar: ");
        int id = scanner.nextInt();
    
       try{
        Customer customer = customerController.readCustomer(id);

        if (customer == null) {
            System.out.println("Cliente con ID " + id + " no encontrado.");
            return;
        }

        System.out.print("Ingrese el ID de la tienda (actual: " + customer.getStoreId() + "): ");
        int storeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
    
        System.out.print("Ingrese el nombre del cliente (actual: " + customer.getFirstName() + "): ");
        String firstName = scanner.nextLine();
    
        System.out.print("Ingrese el apellido del cliente (actual: " + customer.getLastName() + "): ");
        String lastName = scanner.nextLine();
    
        System.out.print("Ingrese id de la direccion (actual: " + customer.getAddressId() + "): ");
        int addressId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
    
        System.out.print("Ingrese fecha (formato YYYY-MM-DD) (actual: " + customer.getCreateDate() + "): ");
        String fechaStr = scanner.nextLine();
    
        // Parse date using java.time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date fecha = (Date) formatter.parse(fechaStr);
    
        // Update customer object with new values (assuming setters exist)
        customer.setStoreId(storeId);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setAddressId(addressId);
        customer.setCreateDate(fecha);
    
        // Call customerController.updateCustomer method
        customerController.updateCustomer(customer);
    
        System.out.println("Cliente actualizado exitosamente.");


        }catch(SQLException e) {
            System.err.println("Error al actualizar cliente: " + e.getMessage());
        }
        
    
        
    }

    private static void deleteCustomer(Scanner scanner) {
        System.out.print("Ingrese el ID del cliente a eliminar: ");
        int customer_id = scanner.nextInt();
    
        try {
            customerController.deleteCustomer(customer_id);
            System.out.println("Cliente eliminado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar cliente: " + e.getMessage());
        }
    }

   private static void listCustomers() {
    try {
        customerController.listCustomers().forEach((id, customer) -> {
            System.out.println("ID: " + customer.getCustomerId() + ", Nombre: " + customer.getFirstName() +
                    ", Apellido: " + customer.getLastName());
        });
    } catch (SQLException e) {
        System.err.println("Error al obtener lista de clientes: " + e.getMessage());
    }
}

    // Métodos para gestionar Rentas
    private static void createRental(Scanner scanner) {
        System.out.print("Ingrese el ID de la renta: ");
        int rentalId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la fecha de renta (YYYY-MM-DD): ");
        String rentalDateStr = scanner.nextLine();
        System.out.print("Ingrese el ID del inventario: ");
        int inventoryId = scanner.nextInt();
        System.out.print("Ingrese el ID del cliente: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la fecha de devolución (YYYY-MM-DD): ");
        String returnDateStr = scanner.nextLine();
        System.out.print("Ingrese el ID del personal: ");
        int staffId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la última fecha de actualizacion (YYYY-MM-DD): ");
        String lastUpdateStr = scanner.nextLine();

        Date rentalDate = Date.valueOf(rentalDateStr);
        Date returnDate = Date.valueOf(returnDateStr);
        Date lastUpdate = Date.valueOf(lastUpdateStr);

        Rental rental = new Rental(rentalId, rentalDate, inventoryId, customerId, returnDate, staffId, lastUpdate);
        rentalController.createRental(rental);
        System.out.println("Renta creada exitosamente.");
    }

    private static void readRental(Scanner scanner) {
        System.out.print("Ingrese el ID de la renta: ");
        int rentalId = scanner.nextInt();
        Rental rental = rentalController.readRental(rentalId);
        if (rental != null) {
            System.out.println("ID de Renta: " + rental.getRentalId());
            System.out.println("Fecha de Renta: " + rental.getRentalDate());
            System.out.println("ID de Inventario: " + rental.getInventoryId());
            System.out.println("ID de Cliente: " + rental.getCustomerId());
            System.out.println("Fecha de Devolucion: " + rental.getReturnDate());
            System.out.println("ID de Personal: " + rental.getStaffId());
            System.out.println("ultima Fecha de Actualizacion: " + rental.getLastUpdate());
        } else {
            System.out.println("Renta no encontrada.");
        }
    }

    private static void updateRental(Scanner scanner) {
        System.out.print("Ingrese el ID de la renta a actualizar: ");
        int rentalId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la nueva fecha de renta (YYYY-MM-DD): ");
        String rentalDateStr = scanner.nextLine();
        System.out.print("Ingrese el nuevo ID de inventario: ");
        int inventoryId = scanner.nextInt();
        System.out.print("Ingrese el nuevo ID de cliente: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la nueva fecha de devolucion (YYYY-MM-DD): ");
        String returnDateStr = scanner.nextLine();
        System.out.print("Ingrese el nuevo ID de personal: ");
        int staffId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la nueva ultima fecha de actualizacion (YYYY-MM-DD): ");
        String lastUpdateStr = scanner.nextLine();

        Date rentalDate = Date.valueOf(rentalDateStr);
        Date returnDate = Date.valueOf(returnDateStr);
        Date lastUpdate = Date.valueOf(lastUpdateStr);

        Rental rental = new Rental(rentalId, rentalDate, inventoryId, customerId, returnDate, staffId, lastUpdate);
        rentalController.updateRental(rental);
        System.out.println("Renta actualizada exitosamente.");
    }

    private static void deleteRental(Scanner scanner) {
        System.out.print("Ingrese el ID de la renta a eliminar: ");
        int rentalId = scanner.nextInt();
        rentalController.deleteRental(rentalId);
        System.out.println("Renta eliminada exitosamente.");
    }

    private static void listRentals() {
        rentalController.listRentals().forEach((rentalId, rental) -> {
            System.out.println("ID de Renta: " + rental.getRentalId() + ", Fecha de Renta: " + rental.getRentalDate() +
                    ", ID de Inventario: " + rental.getInventoryId() + ", ID de Cliente: " + rental.getCustomerId() +
                    ", Fecha de Devolucion: " + rental.getReturnDate() + ", ID de Personal: " + rental.getStaffId() +
                    ", Ultima Fecha de Actualizacion: " + rental.getLastUpdate());
        });
    }
}
