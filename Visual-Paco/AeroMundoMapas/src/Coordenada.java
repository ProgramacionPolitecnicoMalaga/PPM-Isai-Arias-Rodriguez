
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;

public class Coordenada extends Coordinate implements ICoordinate {
    double Lat ,Long;

    public Coordenada(double lat, double aLong) {
        super(lat,aLong);
        Lat = lat;
        Long = aLong;
    }

    @Override
    public double getLat() {
        return Lat;
    }

    @Override
    public void setLat(double v) {
        this.Lat=v;
    }

    @Override
    public double getLon() {
        return Long;
    }

    @Override
    public void setLon(double v) {
        this.Long=v;
    }
}
