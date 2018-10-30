package sequenceList;

// 创建一个player的类来测试SequenceList
class BasketballPlayer {
    private String name;
    private String id;

    public BasketballPlayer(String name, String id){
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "name:" + name + " ,id: " + id;
    }

    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
}


public class Test{
    public static void main(String[] args){
        SequenceList<BasketballPlayer> playerSequenceList = new SequenceList<>();

        //创建player类型的数据，并将这些数据添加到sequenceList中，每个数据都添加到上一个数据的后面
        BasketballPlayer player1 = new BasketballPlayer("Anthony", "001");
        playerSequenceList.add(player1);
        BasketballPlayer player2 = new BasketballPlayer("Kobe", "002");
        playerSequenceList.add(player2);
        BasketballPlayer player3 = new BasketballPlayer("Curry", "003");
        playerSequenceList.add(player3);
        BasketballPlayer player4 = new BasketballPlayer("Lebron", "004");
        playerSequenceList.add(player4);
        BasketballPlayer player5 = new BasketballPlayer("Durant", "005");
        playerSequenceList.add(player5);
        BasketballPlayer player6 = new BasketballPlayer("Harden", "006");
        playerSequenceList.add(player6);
        BasketballPlayer player7 = new BasketballPlayer("Jordan", "007");
        playerSequenceList.add(player7);
        BasketballPlayer player8 = new BasketballPlayer("YaoMing", "008");
        playerSequenceList.add(player8);


        //测试插入方法
        System.out.println("before insert, " + player4.getName()+"'s index = " + playerSequenceList.getIndex(player4));
        int primaryIndex = playerSequenceList.getIndex(player4);

        BasketballPlayer player9 = new BasketballPlayer("Wade", "009");
        playerSequenceList.add(3, player9);
        System.out.println("after insert, " + player4.getName()+"'s index = " + playerSequenceList.getIndex(player4)
                + ", now, the index of " + primaryIndex + " is " + playerSequenceList.getElement(primaryIndex).getName());

        
        //测试使用下标删除元素的方法
        System.out.println("before remove, the 8th element is : " + playerSequenceList.getElement(7) + ", the size of list is : " + playerSequenceList.getSize());
        playerSequenceList.remove(7);
        System.out.println("after remove, the 8th element is : " + playerSequenceList.getElement(7) + ", the size of list is : " + playerSequenceList.getSize());


       //测试删除指定元素的方法
        int removeIndex = playerSequenceList.getIndex(player6);
        System.out.println("before remove, the " + removeIndex + "th element is : "+ player6 + ", the size of list is : " + playerSequenceList.getSize());
        playerSequenceList.remove(player6);
        System.out.println("after remove, the " + removeIndex +"th element is : " + playerSequenceList.getElement(removeIndex) + ", the size of list is : " + playerSequenceList.getSize());


        //测试setElement(E oldElement, E newElement)方法
        int modifiedIndex = playerSequenceList.getIndex(player8);
        BasketballPlayer newInformation1 = new BasketballPlayer("Paul","010");
        System.out.println("before modified, the " + modifiedIndex + "th element is " + playerSequenceList.getElement(modifiedIndex));
        playerSequenceList.setElement(player8, newInformation1);
        System.out.println("after modified, the " + modifiedIndex + "th element is " + playerSequenceList.getElement(modifiedIndex));


        //测试setElement(int index, E newElement)
        System.out.println("before modified, the " + 8 + "th element is " + playerSequenceList.getElement(7));
        BasketballPlayer newInformation2 = new BasketballPlayer("O'neal", "011");
        playerSequenceList.setElement(7, newInformation2);
        System.out.println("before modified, the " + 8 + "th element is " + playerSequenceList.getElement(7));

        //测试查找方法
        System.out.println("当查找一个不存在的数据时: " + playerSequenceList.getIndex(player7));

        System.out.println(playerSequenceList);
    }
}