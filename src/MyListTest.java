public class MyListTest {
    public static void main(String[] args) {
        Animal animal1 = new Animal(1,"cho");
        Animal animal2 = new Animal(2,"meo");

      MyList<Animal> animalMyList = new MyList<>();
      animalMyList.add(animal1);
      animalMyList.add(animal2);

        for (int i = 0; i <animalMyList.size() ; i++) {
            System.out.println(animalMyList.get(i).toString());
        }
    }

}
