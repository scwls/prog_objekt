public class Main {
    public static void main(String[] args) {
        CustomList<String> list = new CustomList<>();
        list.getLast();
        // BARDZO BARDZO BARDZO BARDZO BARDZO BARDZO NIEOPTYMALNIE
        for(int i=0; i < list.size(); i++)
            System.out.println(list.get(i));

        for (String s : list) System.out.println(s);
    }
}
