public class Anime {

    /**
     * <h1>Anime</h1>
     * A data representation of weeb cartoons.
     * <p>
     * name - The name of the anime.
     * <p>
     * episodes - The amount of episodes.
     * <p>
     * status - The status of the anime.
     * <p>
     *
     * @author  Victor Gustafsson
     * @version 1.0
     * @since   2020-01-13
     */

    String name;
    int episodes;
    String status;

    /**
     * Standard constructor.
     * @param name The name of the anime.
     * @param episodes The amount of episodes.
     * @param status The status of the anime.
     */

    public Anime(String name, int episodes, String status) {
        this.name = name;
        this.episodes = episodes;
        this.status = status;
    }
}
