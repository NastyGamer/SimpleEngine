package simple.engine.loaders;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.stream.Stream;

public abstract class Loader<T> {

    protected final HashMap<String, T> content = new HashMap<>();

    public abstract void preload(Stream<Path> path);

    public abstract T get(String name);
}
