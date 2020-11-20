package test_work.preparing;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class WorkerTest {

    @Test
    void salary() throws IOException {
        final String dir = "./src/test_work.preparing_test_work/task_1";

        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(new FixedWorker("Dima", 222));
        workers.add(new HourWorker("efisejif", 222));
        workers.add(new FixedWorker("sefjdf", 222));
        workers.add(new HourWorker("sdnfndf", 222));
        workers.add(new HourWorker("2312", 222));
        workers.add(new FixedWorker("12333", 222));
        workers.add(new FixedWorker("323333", 222));
        workers.sort((w1, w2) -> Double.compare(w1.getMonth(), w2.getMonth()) == 0
                ? w1.getName().compareTo(w2.getName())
                : Double.compare(w1.getMonth(), w2.getMonth()));
        for (int i = 0; i < 5; i++) System.out.println(workers.get(i).getName());
        for (int i = workers.size() - 4; i < workers.size(); i++) System.out.println(workers.get(i).getId());
        FileWriter fileWriter = new FileWriter(dir + "workers.txt");
        for (Worker worker: workers) {
            fileWriter.write(String.format("%-5d %-30s %-15.2f %s\n",
                    worker.getId(),
                    worker.getName(),
                    worker.getMonth(),
                    worker.getClass().getCanonicalName().toLowerCase().contains("fixed")
                            ? "fixed"
                            : "hour"
            ));
        }
        fileWriter.close();
        FileReader fileReader = new FileReader(dir + "workers.txt");
        Scanner scanner = new Scanner(fileReader);
        ArrayList<Worker> workersOut = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] lineSplit = scanner.nextLine().strip().split(" +");
            workersOut.add(new Worker(
                    Integer.parseInt(lineSplit[0]),
                    lineSplit[1],
                    Double.parseDouble(lineSplit[2].replace(',', '.')))
            );
        }
        fileReader.close();
    }
}