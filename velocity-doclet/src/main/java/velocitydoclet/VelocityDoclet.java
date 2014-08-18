package velocitydoclet;

import com.sun.javadoc.*;
import org.apache.commons.lang.*;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.*;

public class VelocityDoclet {

    private final RootDoc root;
    private final String destinationDir;
    private final String templateOverview;
    private final String templatePackage;
    private final String templateClass;
    private final String outputExtension;

    public VelocityDoclet(RootDoc root, String destinationDir, String templateOverview, String templatePackage, String templateClass, String outputExtension) {
        this.root = root;
        this.destinationDir = destinationDir;
        this.templateOverview = templateOverview;
        this.templatePackage = templatePackage;
        this.templateClass = templateClass;
        this.outputExtension = outputExtension;
    }

    private void run() {
        System.out.println("Generating documentation...");

        Velocity.init();

        File file = new File(destinationDir);
        file.mkdirs();

        if (StringUtils.isNotBlank(templateOverview)) {
            VelocityContext context = new VelocityContext();
            context.put("root", root);
            StringWriter writer = new StringWriter();
            Reader reader = newReader(templateOverview);
            boolean evaluated = Velocity.evaluate(context, writer, "overview", reader);
            write(writer.toString(), new File(destinationDir, "overview" + outputExtension));
        }

        PackageDoc[] packages = root.specifiedPackages();
        for (PackageDoc pkg : packages) {
            String packagePath = pkg.name().replace('.', SystemUtils.FILE_SEPARATOR.charAt(0));
            File path = new File(destinationDir, packagePath);
            path.mkdirs();

            if (StringUtils.isNotBlank(templatePackage)) {
                VelocityContext context = new VelocityContext();
                context.put("package", pkg);
                StringWriter writer = new StringWriter();
                Reader reader = newReader(templatePackage);
                boolean evaluated = Velocity.evaluate(context, writer, "package", reader);
                write(writer.toString(), new File(destinationDir, pkg.name() + "." + outputExtension));
            }

            if (StringUtils.isNotBlank(templateClass)) {
                Reader reader = newReader(templateClass);

                for (ClassDoc clazz : pkg.allClasses()) {
                    VelocityContext context = new VelocityContext();
                    context.put("class", clazz);
                    StringWriter writer = new StringWriter();
                    boolean evaluated = Velocity.evaluate(context, writer, "class", reader);
                    String content = writer.toString();
                    if (StringUtils.isNotBlank(content)) {
                        String fileName = (String) context.get("filename");
                        if (fileName == null)
                            fileName = clazz.name();
                        write(content, new File(path, fileName + "." + outputExtension));
                    }
                }
            }
        }

        System.out.println("... done");
    }

    private Reader newReader(String path) {
        try {
            return new FileReader(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Unable to read '" + path + "'", e);
        }
    }

    public static boolean start(RootDoc root) {
        String destinationDir = System.getProperty("java.io.tmpdir");
        String templateOverview = null;
        String templatePackage = null;
        String templateClass = null;
        String outputExtension = "html";
        String[][] options = root.options();
        for (int i = 0; i < options.length; i++) {
            String[] opt = options[i];
            if (opt[0].equals("-d"))
                destinationDir = opt[1];
            else if (opt[0].equals("-template-overview"))
                templateOverview = opt[1];
            else if (opt[0].equals("-template-package"))
                templatePackage = opt[1];
            else if (opt[0].equals("-template-class"))
                templateClass = opt[1];
            else if (opt[0].equals("-output-extension"))
                outputExtension = opt[1];
        }

        VelocityDoclet doclet = new VelocityDoclet(root, destinationDir, templateOverview, templatePackage, templateClass, outputExtension);
        doclet.run();

        return true;
    }

    public static int optionLength(String option) {
        if(option.equals("-d"))
            return 2;
        if(option.equals("-template-overview"))
            return 2;
        if(option.equals("-template-package"))
            return 2;
        if(option.equals("-template-class"))
            return 2;
        if(option.equals("-output-extension"))
            return 2;
        return 0;
    }

    private static void write(String content, File file) {
        try {
            FileWriter fwriter = new FileWriter(file);
            fwriter.append(content);
            fwriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
