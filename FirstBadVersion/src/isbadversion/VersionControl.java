package isbadversion;

public class VersionControl {
    int badVersion;

    void setBadVersion(int version) {
        badVersion = version;
    }

    boolean isBadVersion(int version) {
        return (version >= badVersion);
    }
}
