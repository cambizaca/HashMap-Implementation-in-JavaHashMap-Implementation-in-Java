package assignment3_f20;

public class HashMap_Playground {
/*
 * you will test your own HashMap implementation in here
 *
 * we will replace this with our own when grading, and will
 * do what you should do in here... create TreeMap objects,
 * put data into them, take data out, look for values stored
 * in it, checking size, and looking at the HMCells to see if they 
 * are all linked up correctly chains in the hash table
 * 
*/
  
  public static void main(String[] args) {
    // sample manual tests are shown
    // it is up to you to test it thoroughly and make sure
    // the methods behave as requested above in the interface
  
    // do not simple depend on the oracle test we will give
    // use the oracle tests as a way of checking AFTER you have done
    // your own testing

    HashMap hm = new HashMap_imp(1);
    System.out.println(hm.getTable().length); // expect 2
    System.out.println(hm.size()); // expect 0
    Value v1 = new Value_imp(1, 50, 20);
    Value v2 = new Value_imp(2, 100, 20);
    Value v3 = new Value_imp(34567, 99.013, 19);
	Value v4 = new Value_imp(45678, 55.70, 35);
	Value v5 = new Value_imp(56789, 77.91, 32);


//    hm.put("a", v1);
//    hm.put("b", v2); //extend to  len 4
    
    
    
//    System.out.println(hm.extend());	//extend to  len 8
//    System.out.println(hm.extend());	//extend to  len 16


   
//    Value v3 = new Value_imp(34567, 99.013, 19);
//    Value v4 = new Value_imp(45678, 55.70, 35);
//    Value v5 = new Value_imp(56789, 77.91, 32);
//    Value v6 = new Value_imp(67890, 83.03, 24);
//    
//    hm.put("Jenny", v1);  hm.put("Bill",v2); 
//    hm.put("Steve",v3);   hm.put("Alan",v4);
//    hm.put("Gail",v5);    hm.put("Zed",v6);
//    hm.put("Wilma",v6);   hm.put("Lauren",v6);
//    hm.put("Xray",v6);
    
    hm.put("I", v1);
  //  System.out.println(hm.getTable()); 
  //  System.out.println("first key " + hm.getTable()[0].getKey()); 

    hm.put("S", v2);
    hm.put("J", v5);
    System.out.println(hm.lambda());

    hm.getTable();
    System.out.println(hm.size());


    System.out.println(hm.getKeys()[0]);
    System.out.println(hm.getKeys()[1]);
    System.out.println(hm.getKeys()[2]);
    System.out.println(hm.getKeys()[3]);


  //  System.out.println(" hey "  + hm.getTable()[3].getKey()); 


//    System.out.println("Max key: " + hm.maxKey());
    System.out.println(hm.size());
//    System.out.println(hm.getTable()[0].getKey());

    System.out.println(hm.getTable()[2].getKey());
   //  System.out.println(hm.getTable()[3].getKey());


   //  System.out.println("first key " + hm.getTable()[0].getKey());
//    System.out.println(hm.getTable()[0].getNext().getKey());


//    hm.remove("I");
//    System.out.println(hm.hasKey("a"));
//    System.out.println(hm.getTable()); 


    
    // hm.put("b", null);
//    System.out.println(hm.extend());
//    System.out.println(hm.extend());
//    System.out.println("cool");
//    System.out.println(hm.get("a").getIdNum());
//    System.out.println(hm.get("a").getScore());
//    System.out.println(hm.get("a").getAge());
//    
//
//
//    System.out.println(hm.lambda());



    /*
    System.out.println(hm.size()); // expect 9
    System.out.println(hm.hasKey("Bill")); // expect true
    System.out.println(hm.hasKey("Zorro")); // expect false

    // etc...
     * 
     */

  }

}
