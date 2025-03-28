import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MinimumBidWrapper minimumBidWrapper = new MinimumBidWrapper(10);
        PriorityQueue<Bidder> maxHeap = new PriorityQueue<>((b1, b2) -> b2.getBid() - b1.getBid()); //((a, b) -> b - a) makes the largest element appear at top
        Bidder bidder = new Bidder();
        Scanner scanner = new Scanner(System.in);

        //(1000 milliseconds = 1 second)
        long startTime = System.currentTimeMillis();
        long auctionDuration = 15000;

        System.out.println("AUCTION START " + auctionDuration / 1000 + " seconds");
        while (System.currentTimeMillis() - startTime < auctionDuration) {
            System.out.println("Please enter your bidder ID: ");
            int id = scanner.nextInt();
            System.out.println("Please enter the minimum bid: " + minimumBidWrapper.minimumBid);
            int bid = scanner.nextInt();
            bidder.placeBid(bid, maxHeap, id, minimumBidWrapper);

            //Sleep for a second (1 ms) before accepting new bids
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // After auction timeout:
        System.out.println("----------------------------------");
        if (maxHeap.isEmpty()) {
            System.out.println("No bids placed.");
        } else {
            System.out.println("Highest Bid: $" + maxHeap.peek().getBid() + " from bidder: " + maxHeap.peek().getId());
        }

        System.out.println("----------------------------------");
        System.out.println("All Bids: ");
        for (Bidder b : maxHeap) {
            System.out.println("Bidder " + b.getId() + ": $" + b.getBid());
        }
    }
}
