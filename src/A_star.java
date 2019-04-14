import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class A_star {

    private int start_id;
    private int end_id;

    private static ArrayList<Integer> road;

    private A_star(int start_id, int end_id)
    {
        this.start_id = start_id;
        this.end_id = end_id;
        this.road = new ArrayList<>();
    }

    // Singleton --- immutable
    public static final A_star getInstance(int start_id, int end_id)
    {
        return new A_star(start_id, end_id);
    }

    public List eval(HashMap<Integer, Integer> id_entity, int[][] pathMatrix, int size)
    {
        for (int i = 0; i < size; i++)
        {
            if (i == start_id)
            {
                int min = Integer.MAX_VALUE; // static variable

                for (int col = 0; col < size; col++)
                {
                    int cursum = 0;

                    if (pathMatrix[i][col] != 0)
                    {
                        cursum += pathMatrix[i][col] + id_entity.get(col);
                        if (cursum < min) min = cursum;
                    }


                }

            }

            road.add(i);

        }



        return road;
    }

}
