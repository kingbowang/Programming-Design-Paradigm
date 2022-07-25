
import java.util.List;

/**
 * This is a gear interface.
 */
public interface Gear extends Comparable<Gear> {

    /**
     * Returns the name of the gear.
     *
     * @return name
     */
    String getName();

    /**
     * Returns the adjective of the gear.
     *
     * @return adjective
     */
    String getAdjective();
}

