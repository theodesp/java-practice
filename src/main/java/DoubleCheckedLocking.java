public class DoubleCheckedLocking {
    private class Resource {
        private final int data;
        Resource(int data) {
            this.data = data;
        }
    }
    private volatile Resource resource = null;
    public Resource getResource() {
        if (resource == null) {
            synchronized (this) {
                if (resource == null) {
                    resource = new Resource(1);
                }
            }
        }
        return resource;
    }

    public static void main(String[] args) {
        var self = new DoubleCheckedLocking();
        var res = self.getResource();
        System.out.println(res.data);
    }
}
