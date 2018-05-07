import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestMybatisGenerator {
    public static void main(String[] args) {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        try {
            File configFile = new File(MyBatisGenerator.class.getClassLoader().getResource("generatorConfig.xml").toURI());
            ConfigurationParser configurationParser = new ConfigurationParser(warnings);
            Configuration configuration = configurationParser.parseConfiguration(configFile);
            ShellCallback callback = new DefaultShellCallback(overwrite);

            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
