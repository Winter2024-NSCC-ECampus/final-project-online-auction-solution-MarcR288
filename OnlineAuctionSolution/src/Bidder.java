import java.util.PriorityQueue;

public class Bidder {
    private int id;
    private int bid;

    public Bidder(int bid,int id) {
        this.bid = bid;
        this.id = id;
    }

    public Bidder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public void placeBid(int bid, PriorityQueue<Bidder> heap, int id, MinimumBidWrapper minimumBidWrapper) {
        //Only allow bids that meet or exceed the minimum bid
        if (bid >= minimumBidWrapper.minimumBid) {
            //Update the minimum bid to the current bid value
            minimumBidWrapper.minimumBid = bid;
            //Add the valid bid to the heap
            heap.add(new Bidder(bid, id));
        } else {
            System.out.println("Bid of " + bid + " from bidder "+ id + " rejected. Must be at least: $" + minimumBidWrapper.minimumBid);
        }
    }
}

class MinimumBidWrapper {
    public int minimumBid;

    public MinimumBidWrapper(int minimumBid) {
        this.minimumBid = minimumBid;
    }

    @Override
    public String toString() {
        return String.valueOf(minimumBid); // Return the minimum bid as a string
    }

}

