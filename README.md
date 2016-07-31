<h1>Spring Boot Oracle Demo for Pivotal Cloud Foundry</h1>

The following demo shows how to access an Oracle Database using Spring boot application deployed to Pivotal Cloud Foundry. This demo
will use PCFDev a local version of PCF which you can run on your laptop. For more information on PCFDev use the link below

  https://pivotal.io/pcf-dev

![alt tag](https://dl.dropboxusercontent.com/u/15829935/platform-demos/images/pcf-oracle-1.png)

<h3> Steps </h3>

- Clone as shown below

```
$ git clone https://github.com/papicella/PCFOracleDemo.git
```

- Edit "./PCFOracleDemo/src/main/resources/application.properties" and add your oracle EMP schema connection details

```
error.whitelabel.enabled=false

oracle.username=scott
oracle.password=tiger
oracle.url=jdbc:oracle:thin:@//192.168.20.131:1521/ora11gr2
```

EMP table defined as follows 

```
SCOTT@192.168.20.131:1521/ora11gr2> select * from emp;

     EMPNO ENAME      JOB	       MGR HIREDATE	    SAL       COMM     DEPTNO
---------- ---------- --------- ---------- --------- ---------- ---------- ----------
      7369 SMITH      CLERK	      7902 17-DEC-80	    800 	 0	   20
      7499 ALLEN      SALESMAN	      7698 20-FEB-81	   1600        300	   30
      7521 WARD       SALESMAN	      7698 22-FEB-81	   1250        500	   30
      7566 JONES      MANAGER	      7839 02-APR-81	   2975 	 0	   20
      7654 MARTIN     SALESMAN	      7698 28-SEP-81	   1250       1400	   30
      7698 BLAKE      MANAGER	      7839 01-MAY-81	   2850 	 0	   30
      7782 CLARK      MANAGER	      7839 09-JUN-81	   2450 	 0	   10
      7788 SCOTT      ANALYST	      7566 19-APR-87	   3000 	 0	   20
      7839 KING       PRESIDENT #	   17-NOV-81	   5000 	 0	   10
      7844 TURNER     SALESMAN	      7698 08-SEP-81	   1500 	 0	   30
      7876 ADAMS      CLERK	      7788 23-MAY-87	   1100 	 0	   20
      7900 JAMES      CLERK	      7698 03-DEC-81	    950 	 0	   30
      7902 FORD       ANALYST	      7566 03-DEC-81	   3000 	 0	   20
      7934 MILLER     CLERK	      7782 23-JAN-82	   1300 	 0	   10

14 rows selected.
```

- Package as per below

```
cd PCFOracleDemo
$ mvn package
```

- Deploy as follows targeting PCFDev is this demo

```
pasapicella@pas-macbook:~/pivotal/DemoProjects/spring-starter/pivotal/PCFOracleDemo$ cf push
Using manifest file /Users/pasapicella/pivotal/DemoProjects/spring-starter/pivotal/PCFOracleDemo/manifest.yml

Creating app springboot-oracle in org pcfdev-org / space pcfdev-space as admin...
OK

Creating route springboot-oracle.local.pcfdev.io...
OK

Binding springboot-oracle.local.pcfdev.io to springboot-oracle...
OK

Uploading springboot-oracle...
Uploading app files from: /var/folders/c3/27vscm613fjb6g8f5jmc2x_w0000gp/T/unzipped-app506692756
Uploading 26.3M, 154 files
Done uploading
OK

Starting app springboot-oracle in org pcfdev-org / space pcfdev-space as admin...
Downloading binary_buildpack...
Downloading python_buildpack...
Downloading staticfile_buildpack...
Downloading java_buildpack...
Downloading php_buildpack...
Downloading ruby_buildpack...
Downloading go_buildpack...
Downloading nodejs_buildpack...
Downloaded staticfile_buildpack
Downloaded binary_buildpack (8.3K)
Downloaded php_buildpack (262.3M)
Downloaded java_buildpack (241.6M)
Downloaded go_buildpack (450.3M)
Downloaded ruby_buildpack (247.7M)
Downloaded python_buildpack (254.1M)
Downloaded nodejs_buildpack (60.7M)
Creating container
Successfully created container
Downloading app package...
Downloaded app package (23.5M)
Staging...
-----> Java Buildpack Version: v3.6 (offline) | https://github.com/cloudfoundry/java-buildpack.git#5194155
-----> Downloading Open Jdk JRE 1.8.0_71 from https://download.run.pivotal.io/openjdk/trusty/x86_64/openjdk-1.8.0_71.tar.gz (found in cache)
       Expanding Open Jdk JRE to .java-buildpack/open_jdk_jre (1.2s)
-----> Downloading Open JDK Like Memory Calculator 2.0.1_RELEASE from https://download.run.pivotal.io/memory-calculator/trusty/x86_64/memory-calculator-2.0.1_RELEASE.tar.gz (found in cache)
       Memory Settings: -XX:MetaspaceSize=64M -XX:MaxMetaspaceSize=64M -Xss995K -Xmx382293K -Xms382293K
-----> Downloading Spring Auto Reconfiguration 1.10.0_RELEASE from https://download.run.pivotal.io/auto-reconfiguration/auto-reconfiguration-1.10.0_RELEASE.jar (found in cache)
Exit status 0
Staging complete
Uploading droplet, build artifacts cache...
Uploading build artifacts cache...
Uploading droplet...
Uploaded build artifacts cache (109B)
Uploaded droplet (68.4M)
Uploading complete

1 of 1 instances running

App started


OK

App springboot-oracle was started using this command `CALCULATED_MEMORY=$($PWD/.java-buildpack/open_jdk_jre/bin/java-buildpack-memory-calculator-2.0.1_RELEASE -memorySizes=metaspace:64m.. -memoryWeights=heap:75,metaspace:10,native:10,stack:5 -memoryInitials=heap:100%,metaspace:100% -totMemory=$MEMORY_LIMIT) && JAVA_OPTS="-Djava.io.tmpdir=$TMPDIR -XX:OnOutOfMemoryError=$PWD/.java-buildpack/open_jdk_jre/bin/killjava.sh $CALCULATED_MEMORY" && SERVER_PORT=$PORT eval exec $PWD/.java-buildpack/open_jdk_jre/bin/java $JAVA_OPTS -cp $PWD/.:$PWD/.java-buildpack/spring_auto_reconfiguration/spring_auto_reconfiguration-1.10.0_RELEASE.jar org.springframework.boot.loader.JarLauncher`

Showing health and status for app springboot-oracle in org pcfdev-org / space pcfdev-space as admin...
OK

requested state: started
instances: 1/1
usage: 512M x 1 instances
urls: springboot-oracle.local.pcfdev.io
last uploaded: Sun Jul 31 01:23:03 UTC 2016
stack: unknown
buildpack: java-buildpack=v3.6-offline-https://github.com/cloudfoundry/java-buildpack.git#5194155 java-main open-jdk-like-jre=1.8.0_71 open-jdk-like-memory-calculator=2.0.1_RELEASE spring-auto-reconfiguration=1.10.0_RELEASE

     state     since                    cpu    memory      disk        details
#0   running   2016-07-31 11:24:26 AM   0.0%   0 of 512M   0 of 512M
pasapicella@pas-macbook:~/pivotal/DemoProjects/spring-starter/pivotal/PCFOracleDemo$ cf apps
Getting apps in org pcfdev-org / space pcfdev-space as admin...
OK

name                requested state   instances   memory   disk   urls
springboot-oracle   started           1/1         512M     512M   springboot-oracle.local.pcfdev.io
```

- Access as follows

```
http://springboot-oracle.local.pcfdev.io/
```

<hr />
Pas Apicella [papicella at pivotal.io] is a Senior Platform Architect at Pivotal