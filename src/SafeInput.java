import java.util.Scanner;
public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.print("\n" +prompt + ":"); // show prompt add space//
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;

    }

    public static int getInt(Scanner pipe, String prompt)
    {
        int number;
        while (true)
        {
            System.out.println(prompt);

            if (pipe.hasNextInt())
            {
                number = pipe.nextInt();
                pipe.nextLine();
                break;
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("Invalid input. Please enter an integer: ");
            }
        }
        return number;
    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        double number;
        while (true)
        {
            System.out.println(prompt);
            if (pipe.hasNextDouble())
            {
                number = pipe.nextDouble();
                pipe.nextLine();
                break;
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("Invalid input. Please enter a double: ");
            }
        }
        return number;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int number;
        while (true)
        {
            System.out.println(prompt + low + " and " + high + ": ");
            if (pipe.hasNextInt())
            {
                number = pipe.nextInt();
                pipe.nextLine();

                if (number >= low && number <= high)
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid input. Please enter an integer between " + low + " and " + high + ": ");
                }
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return number;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double number;
        while (true) {
            System.out.println(prompt + low + " and " + high + ": ");
            if (pipe.hasNextDouble())
            {
                number = pipe.nextDouble();
                pipe.nextLine();

                if (number >= low && number <= high)
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid input. Please enter a double between " + low + " and " + high + ": ");
                }
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("Invalid input. Please enter a valid double.");
            }
        }
        return number;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean isValid = false;
        boolean confirmation = false;

        while (!isValid)
        {
            System.out.println(prompt);

            String in = pipe.nextLine().trim().toLowerCase();

            if (in.equals("y") || in.equals("yes"))
            {
                isValid = true;
                confirmation = true;
            }
            else if (in.equals("n") || in.equals("no"))
            {
                isValid = true;
                confirmation = false;
            }
            else
            {
                System.out.println("Invalid input. Please enter 'Y' or 'N'. ");
            }
        }
        return confirmation;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String in;
        while (true)
        {
            System.out.println(prompt);

            in = pipe.nextLine();

            if (in.matches(regEx))
            {
                break;
            }
            else
            {
                System.out.println("Invalid entry. Please enter a string matching the pattern: " + regEx);
            }
        }
        return in;
    }

    public static void prettyHeader(String msg)
    {
        int width = 60;
        int messageWidth = msg.length();
        int stars = (width - messageWidth -4) / 2;

        printLine('*', width);
        printLine('*',stars);
        printMessageLine(msg, stars);
        printLine('*', stars);
        printLine('*', width);
    }

    public static void printLine(char ch, int length)
    {
        for (int i = 0; i < length; i++)
        {
            System.out.print(ch);
        }
        System.out.println();
    }
    public static void printMessageLine(String msg, int stars)
    {
        System.out.print("***");
        printSpace(' ', stars);
        System.out.print(msg);
        printSpace(' ', stars);
        System.out.print("***");
    }

    public static void printSpace(char ch, int count)
    {
        for (int i = 0; i < count; i++);
        {
            System.out.print(ch);
        }
    }



}
