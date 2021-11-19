package valueobjects;

/**
 * How to interpret this object?
 * 1. check the L2 Protocol: the packets of ATM are called "cells", of Ethernet they are called "frames"
 * 2. check if a padding is needed, else don't include it in the output
 *
 * You can READ the values from this class accessing the variables directly,
 * PLEASE don't even consider changing one existing objects instance variables as this is sureley causing days of headace
 */

public class OutputValues {
    public final L2Protocol PROTOCOL;
    public final int TOTAL_BYTES;
    public final int NR_PACKETS;
    public final int BYTES_OF_PADDING;

    public OutputValues(L2Protocol protocol, int total_bytes, int nr_packets, int bytes_of_padding) {
        PROTOCOL = protocol;
        TOTAL_BYTES = total_bytes;
        NR_PACKETS = nr_packets;
        BYTES_OF_PADDING = bytes_of_padding;
    }
}
