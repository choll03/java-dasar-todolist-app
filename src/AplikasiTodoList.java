public class AplikasiTodoList {

    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * menampilkan todo list
     */
    public static void showTodoList() {
        System.out.println("TODO LIST APP");
        for(var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if(todo != null) {
                System.out.println(no + ". "+ todo);
            }
        }
    }

    public static void testShowTodoList() {
        model[0] = "Belajar Java dasar";
        model[1] = "Studi kasus java dasar";
        model[2] = "Java OOP";
        showTodoList();
    }

    /**
     * menambahkan todo list
     */
    public static void addTodoList(String todo) {
        // cek apakah model penuh?
        boolean isFull = true;
        for (var i= 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        // jika penuh resize dengan ukuran 2x lipat
        if(isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (var i=0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // tambahkan data ke posisi array yg null
        for (var i = 0; i < model.length; i++) {
            if(model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (var i = 0; i < 25; i++) {
            addTodoList("Data Todo ke " + i);
        }

        showTodoList();
    }

    /**
     * menghapus todo list
     */
    public static boolean removeTodoList(Integer number) {

        if((number - 1) >= model.length) {
            return false;
        } else if(model[number - 1] == null) {
            return false;
        } else {
            for (var i = (number - 1); i < model.length; i++) {
                if(i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");
        addTodoList("enam");
        addTodoList("tujuh");
        addTodoList("delapan");
        addTodoList("sembilan");
        addTodoList("sepuluh");
        addTodoList("sebelas");
        addTodoList("duabelas");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(4);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        result = removeTodoList(10);
        System.out.println(result);

        showTodoList();
    }

    /**
     * untuk input user
     */
    public static String input(String info) {
        System.out.print(info + " : ");
        return scanner.nextLine();
    }

    public static void testInput() {
        String data = input("Namanya");
        System.out.println("hi " + data);

        String age = input("Umurnya");
        System.out.println("Umur " + age);
    }

    /**
     * menampilkan view todo list
     */
    public static void viewShowTodoList() {
        while (true) {

            showTodoList();

            System.out.println("MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilihan Anda");

            if(input.equals("1")) {
                viewAddTodoList();
            } else if(input.equals("2")) {
                viewRemoveTodoList();
            } else if(input.equals("x")) {
                break;
            } else {
                System.out.println("input tidak dimengerti");
            }
        }
    }

    public static void testViewShowTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");
        viewShowTodoList();
    }

    /**
     * menampilkan view tambah todo list
     */
    public static void viewAddTodoList() {
        String inputData = input("Masukan todo list");
        if(inputData.isEmpty()) {
            System.out.println("Data yang dimasukan tidak boleh kosong");
            viewAddTodoList();
        } else {
            addTodoList(inputData);
            viewShowTodoList();
        }
    }

    /**
     * menampilkan view hapus todo list
     */
    public static void viewRemoveTodoList() {

        System.out.println("MENGHAPUS TODO LIST");

        String inputData = input("Masukan nomor todo list");

        boolean success = removeTodoList(Integer.valueOf(inputData));
        if(!success) {
            System.out.println("Gagal menghapus todo list : " + inputData);
        }
        showTodoList();
    }

    public static void testViewRemoveTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        showTodoList();
        viewRemoveTodoList();
    }
}
