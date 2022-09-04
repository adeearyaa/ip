
package duke;
import java.util.ArrayList;


public class Parser {
    static ArrayList<Task> listOfTasks = new ArrayList<>(100);

    public static String startParse(String input) {

        DukeOperations ops = new DukeOperations();
        TaskList tl = new TaskList();


        String output = input;
        String arr[] = output.split(" ", 2);
        String firstword = arr[0];

        if (output.equals("bye")) {
                return ops.exit();


        } else if (output.equals("list")) {
                return ops.displayList(listOfTasks);

        } else if (firstword.equals("todo")) {
            if (!Storage.fileExists()) {
                    return("File doesnt exist yet");
            }
            try {
                return tl.todo(listOfTasks, arr);
            } catch (DukeException e1) {
                    return(e1.toString());
            }
            } else if (firstword.equals("deadline")) {
                if (!Storage.fileExists()) {
                    return("File doesnt exist yet");
                }

                String arr2[] = arr[1].split("/by ", 2);
                String arr3[] = arr2[1].split(" ", 2);



                return tl.deadline(listOfTasks, arr2[0], arr3[0], arr3[1]);

            } else if (firstword.equals("event")) {
                if (!Storage.fileExists()) {
                    return("File doesnt exist yet");
                }

                String arr2[] = arr[1].split("/at ", 2);
                String arr3[] = arr2[1].split(" ", 2);



                return tl.event(listOfTasks, arr2[0], arr3[0], arr3[1]);

            } else if (firstword.equals("mark")) {
                int num = Integer.parseInt(arr[1]);
                return ops.mark(listOfTasks, num);
            } else if (firstword.equals("unmark")) {
                int num = Integer.parseInt(arr[1]);
                return ops.unmark(listOfTasks, num);
            } else if (firstword.equals("delete")) {
                int num = Integer.parseInt(arr[1]);
                return tl.delete(listOfTasks, num);


            } else if(firstword.equals("find")) {
                String str = arr[1];
                return ops.findWord(str, listOfTasks);



            } else {
                try {
                    ops.randomword(output);
                } catch (DukeException e2) {

                    return(e2.toString());

                }
            }
            return "hi";
        }


    }

