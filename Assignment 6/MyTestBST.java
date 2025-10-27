import java.util.Scanner;
// Name:    Alexander San Agustin-Melendez
// Class:   CS3305/04
// Term:    Fall 2025
// Instructor:  Maxwell Bradley
// Assignment:  6
// IDE Name:    IntelliJ IDEA


public class MyTestBST {

    private static int inputValidation(Scanner sc) {
        //  Start a loop that will not end on its own.
        while (true) {
            String input = sc.nextLine();

            try {
                //  Try to convert input to a number, if successful, return the number. This is the ONLY way to exit the loop.
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                //  If it fails, print an error and the loop will repeat.
                System.out.print("Invalid input, please try again: ");
            }
        }
    }

    private static String strInputValidation(Scanner sc) {
        //  Start a loop that will not end on its own.
        while (true) {
            String input = sc.nextLine();
            if(input != null && !input.trim().isEmpty()){
                return input;
            }
            else{
                System.out.print("Invalid input, please try again: ");
            }
        }
    }


    private static void displayMenu(){
        System.out.println("\n---------MAIN MENU--------");
        System.out.println("""
                 0 - Enter Tree Data Type (integer or string)
                 1 - Insert Data Element
                 2 - Delete Data Element
                 3 - Search for Data Element
                 4 - Print Tree Size
                 5 - Path from Root to Data Element
                 6 - Check if Empty Tree
                 7 - Print Preorder Traversal
                 8 - Print Inorder Traversal
                 9 - Print Postorder Traversal
                 10 - Exit Program""");

        System.out.print("\nEnter option number: ");
    }
    // Functions that checks that the tree has been initialized before any other option. It used treeType variable
    private static boolean noTree(int treeType){
        if(treeType == 0){
            System.out.println("Please select option 0 to set the tree type first.");
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // Tree declaration
        BST<Integer> intTree = null;
        BST<String> strBST = null;


        int treeType = 0; // 0- Unset ; 1- Integer; 2- String

        boolean running = true;


        // === Menu Loop ===
        while(running){
            displayMenu();
            int menuOption = inputValidation(sc);
            System.out.println();

            switch (menuOption){
                case 0:
                    System.out.print("""
                            Please select a Data Type\
                            
                            [1] Integer \t[2] String\
                            
                            Enter an option:\s""");
                    int usrOption = inputValidation(sc);

                    // INTEGER TREE
                    if(usrOption == 1){
                        intTree = new BST<>();
                        treeType = 1;
                        System.out.println("Integer Tree Selected");
                    }
                    // STRING TREE
                    else if(usrOption == 2){
                        strBST = new BST<>();
                        treeType = 2;
                        System.out.println("String tree Selected");
                    }
                    else{
                        System.out.println("Invalid Input");
                    }
                    break;
                case 1:
                    System.out.println("Testing method Insert Data Element (Option 1)");
                    if(!noTree(treeType)){
                        System.out.print("Please insert a Data Element: ");
                        if(treeType == 1 ){
                            int input = inputValidation(sc);
                            System.out.print("BST before inserting " + input + " (Inorder):\t");
                            intTree.inorder();
                            //Checks if the element is not already in the tree
                            if(!intTree.insert(input)){
                                System.out.println("Error, the element is already in the tree");
                            }else{
                                System.out.print("\nBST after inserting " + input + " (Inorder):\t");
                                intTree.inorder();
                                System.out.println();
                            }
                        }
                        else{
                            String input = strInputValidation(sc);

                            System.out.print("BST before inserting " + input + " (Inorder):\t");
                            assert strBST != null;
                            strBST.inorder();

                            if(!strBST.insert(input)){
                                System.out.println("Error, the element is already in the tree");
                            }else{
                                System.out.print("\nBST after inserting " + input + " (Inorder):\t");
                                strBST.inorder();
                                System.out.println();
                            }

                        }
                    }
                    break;
                case 2:
                    System.out.println("Testing method Delete Data Element (Option 2)");
                    if(!noTree(treeType)){
                        System.out.print("Please insert a Data Element: ");
                        if(treeType == 1 ){
                            int input = inputValidation(sc);
                            System.out.print("BST before deleting " + input + " (Inorder):\t");
                            intTree.inorder();
                            System.out.println();

                            if(!intTree.delete(input)){
                                System.out.println(input + " is not in the tree.");
                            }
                            else{
                                System.out.print("\nBST after deleting " + input + " (Inorder):\t");
                                intTree.inorder();
                                System.out.println();
                            }
                        }
                        else{
                            String input = strInputValidation(sc);

                            System.out.print("BST before deleting " + input + " (Inorder):\t");
                            assert strBST != null;
                            strBST.inorder();
                            System.out.println();

                            if(!strBST.delete(input)){
                                System.out.println(input + " is not in the tree.");
                            }
                            else{
                                System.out.print("\nBST after deleting " + input + " (Inorder):\t");
                                strBST.inorder();
                                System.out.println();

                            }

                       }
                    }
                    break;
                case 3:
                    System.out.println("Testing method Search for Data Element (Option 3)");
                    if(!noTree(treeType)){
                        System.out.print("Please insert a Data Element: ");
                        if(treeType == 1 ){
                            int input = inputValidation(sc);
                            System.out.print("Is " + input + " in the tree? " + intTree.search(input));
                            System.out.println();
                        }
                        else{
                            String input = strInputValidation(sc);
                            assert strBST != null;
                            System.out.print("Is " + input + " in the tree? " + strBST.search(input));
                            System.out.println();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Testing method Tree size (Option 4)");
                    if(!noTree(treeType)){
                        if(treeType == 1){
                            System.out.println("Tree size: " + intTree.getSize());
                        }
                        if(treeType == 2){
                            System.out.println("Tree size: " + strBST.getSize());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Testing method Path from Root to Data Element (Option 5)");
                    if(!noTree(treeType)){
                        System.out.print("Please insert a Data Element: ");
                        if(treeType == 1){
                            int input = inputValidation(sc);
                            if(intTree.search(input)){
                                System.out.print("Path from root to " + input + ": ");

                                for(BST.TreeNode<Integer> i : intTree.path(input)){
                                    System.out.print("\t" + i.element);
                                }
                            }else{
                                System.out.println("Error. The element does not exist in the tree");
                            }

                        }
                        if(treeType == 2){

                            String input = strInputValidation(sc);

                            if(strBST.search(input)){
                                System.out.print("Path from root to " + input + ": ");

                                for(BST.TreeNode<String> i : strBST.path(input)){
                                    System.out.print("\t" + i.element);
                                }
                            }else{
                                System.out.println("Error. The element does not exist in the tree.");
                            }


                        }
                    }
                    break;
                case 6:
                    System.out.println("Testing method Check if Empty tree (Option 6)");
                    if(!noTree(treeType)){
                        if(treeType == 1){
                            System.out.println("Is empty tree: " + intTree.isEmpty());
                        }
                        if(treeType == 2){
                            System.out.println("Is empty tree: " + strBST.isEmpty());
                        }
                    }
                    break;
                case 7:
                    System.out.println("Testing method Preorder Traversal (Option 7)");
                    if(!noTree(treeType)){
                        if(treeType == 1){
                            System.out.print("Preorder: ");
                            intTree.preorder();
                        }
                        if(treeType == 2){
                            System.out.print("Preorder: ");
                            strBST.preorder();
                        }
                    }
                    break;
                case 8:
                    System.out.println("Testing method Inorder Traversal (Option 8)");
                    if(!noTree(treeType)){
                        if(treeType == 1){
                            System.out.print("Inorder: ");
                            intTree.inorder();
                        }
                        if(treeType == 2){
                            System.out.print("Inorder: ");
                            strBST.inorder();
                        }
                    }
                    break;
                case 9:
                    System.out.println("Testing method Postorder Traversal (Option 9)");
                    if(!noTree(treeType)){
                        if(treeType == 1){
                            System.out.print("Postorder: ");
                            intTree.postorder();
                        }
                        if(treeType == 2){
                            System.out.print("Postorder: ");
                            strBST.postorder();
                        }
                    }
                    break;
                case 10:
                    running = false;
                    break;
                default:
                    System.out.println("Please enter a valid option.");
                    break;
            }

        }
        // Prompts the user that the program is ending
        System.out.println("Exiting Program...");
    }
}
