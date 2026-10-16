import java.util.Scanner;

class Job {
    int id;
    int deadline;
    int weight;

    Job(int id, int deadline, int weight) {
        this.id = id;
        this.deadline = deadline;
        this.weight = weight;
    }
}

public class JobScheduling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tasks: ");
        int n = sc.nextInt();

        Job[] jobs = new Job[n];

        // Input
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Task " + (i + 1));

            System.out.print("Deadline: ");
            int deadline = sc.nextInt();

            System.out.print("Weight: ");
            int weight = sc.nextInt();

            jobs[i] = new Job(i + 1, deadline, weight);
        }

        // Sort jobs in decreasing order of weight
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (jobs[i].weight < jobs[j].weight) {
                    Job temp = jobs[i];
                    jobs[i] = jobs[j];
                    jobs[j] = temp;
                }
            }
        }

        // Find maximum deadline
        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            if (jobs[i].deadline > maxDeadline) {
                maxDeadline = jobs[i].deadline;
            }
        }

        // Create time slots
        int[] slot = new int[maxDeadline + 1];

        // -1 means slot is empty
        for (int i = 0; i <= maxDeadline; i++) {
            slot[i] = -1;
        }

        int totalWeight = 0;

        // Schedule jobs
        for (int i = 0; i < n; i++) {

            // Try to place job in the latest available slot
            for (int j = jobs[i].deadline; j >= 1; j--) {

                if (slot[j] == -1) {
                    slot[j] = jobs[i].id;
                    totalWeight += jobs[i].weight;
                    break;
                }
            }
        }

        // Display result
        System.out.println("\nJob Sequence:");

        for (int i = 1; i <= maxDeadline; i++) {
            if (slot[i] != -1) {
                System.out.print("T" + slot[i] + " ");
            }
        }

        System.out.println("\nMaximum Weight = " + totalWeight);

        sc.close();
    }
}