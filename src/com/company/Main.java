package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Person persons[] = new Person[15];
        persons[0] = new Person("Аксенов Андрей Витальевич", 34, "Терапевт");
        persons[1] = new Person("Смирнова Алена Викторовна", 25, "Эндокринолог");
        persons[2] = new Person("Черных Александр Иванович", 68, "Педиатр");
        persons[3] = new Person("Котельникова Алина Андреевна", 29, "Психиатр");
        persons[4] = new Person("Ашарафулина Юлия Руслановна", 23, "Заведующий отделением");
        persons[5] = new Person("Туров Александр Евгеньевич", 25, "Невролог");
        persons[6] = new Person("Тришин Антон Владимирович", 27, "Стоматолог");
        persons[7] = new Person("Ооржак Херелмаа Чойгановна", 26, "Скорпион");
        persons[8] = new Person("Гармаева Адилия Игоревна", 27, "Старшая медсестра");
        persons[9] = new Person("Кузнецов Аркадий Семенович", 15, "Стоматолог");
        persons[10] = new Person("Балдан Ай-Суу Михтиевна", 27, "Заведующий отделением");
        persons[11] = new Person("Старикова Дарья Андреевна", 23, "Психиатр");
        persons[12] = new Person("Бартыкова Дара Евгеньевна", 25, "Педиатр");
        persons[13] = new Person("Гуслякова Валерия Игоревна", 27, "Эндокринолог");
        persons[14] = new Person("Масляков Вадим Олегович", 25, "Терапевт");

        int number = 0;

        do {
            number = menu();
            switch (number) {
                case 1 -> {
                    // вывод массива
                    for (Person person : persons) {
                        person.print(person);
                    }

                }
                case 2 -> {
                    // сортировка массива по полю имя
                    for (Person person : persons) {
                        person.sort_cells_name(persons);
                    }

                    // вывод массива
                    for (Person person : persons) {
                        person.print(person);
                    }

                }
                case 3 -> {
                    // сортировка массива по полю возраст
                    for (Person person : persons) {
                        person.sort_cells_age(persons);
                    }

                    // вывод массива
                    for (Person person : persons) {
                        person.print(person);
                    }

                }

                case 4 -> {
                    // сортировка массива по полю должность
                    for (Person person : persons) {
                        person.sort_cells_position(persons);
                    }

                    // вывод массива
                    for (Person person : persons) {
                        person.print(person);
                    }

                }


                case 5 -> {
                    try {
                        PrintStream out = new PrintStream(new File("C://laba1/write_file.txt"));
                        for (Person person : persons) {
                            person.printToFile(out, person);

                        }
                        System.out.println("Данные записаны в файл");
                    } catch (FileNotFoundException e) {
                        System.err.println(e.getMessage());
                    }
                }


                case 6 -> {
                    System.exit(0);
                }

            }
        } while (number < 7);


    }


    static int menu() throws IOException {
        System.out.println("Меню. Нажмите:");
        System.out.println("1 - вывести изначальный массив объектов");
        System.out.println("2 - отсортированный массив по ФИО");
        System.out.println("3 - отсортированный массив по возрасту");
        System.out.println("4 - отсортированный массив по должности");
        System.out.println("5 - вывести массив в файл txt");
        System.out.println("6 - выход из программы");
        System.out.println("Ожидается ввод");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num = reader.readLine();
        int number = Integer.parseInt(num);
        return number;

    }


}
