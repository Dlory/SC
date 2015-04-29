package netdata;

public final class Version {

	public static String getVersion() {
        return Version.class.getPackage().getImplementationVersion();
    }
	
}
