package simple.engine.engine.loaders;

import com.madgag.gif.fmsware.GifDecoder;
import simple.engine.engine.util.ColorOut;

import java.nio.file.Path;
import java.util.stream.Stream;

public class GifLoader extends Loader<GifDecoder> {


    @Override
    public void preload(Stream<Path> path) {
        path.forEach(p -> {
            content.put(p.getFileName().toString(), new GifDecoder() {{
                read(p.toString());
            }});
        });
        ColorOut.print(System.out, String.format("Loaded %d gifs from files.", content.values().size()), ColorOut.GREEN);
    }

    @Override
    public GifDecoder get(String name) {
        if (content.containsKey(name)) return content.get(name);
        if (content.containsKey(name.replace(".", ""))) return content.get(name.replace(".", ""));
        throw new NullPointerException(name.concat(" isn't a gif"));
    }
}
