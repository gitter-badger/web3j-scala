# web3j-scala Ethereum Library

<img src='https://docs.web3j.io/_static/web3j.png' align='right' width='15%'>

<!--[![GitHub version](https://badge.fury.io/gh/mslinn%2Fweb3j-scala.svg)](https://badge.fury.io/gh/mslinn%2Fweb3j-scala)-->
[![Build Status](https://travis-ci.org/mslinn/web3j-scala.svg?branch=master)](https://travis-ci.org/mslinn/web3j-scala)
[![Contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/dwyl/esta/issues)

`web3j-scala` is an idiomatic Scala wrapper around [web3j](https://www.web3j.io) for Ethereum.
`web3j` is a lightweight, reactive, somewhat type safe Java and Android library for integrating with nodes on Ethereum blockchains.
[web3.js](https://github.com/ethereum/web3.js/) is the Node.js library that inspired `web3j` and `web3j-scala`.
All three of these 3 libraries leverage the [json-rpc](https://github.com/ethereum/wiki/wiki/JSON-RPC) protocol that Ethereum clients like [geth](https://github.com/ethereum/go-ethereum/wiki/geth) support.
`web3j-scala` provides type safety and enhanced scalability over its Java and JavaScript cousins,
as well as the pleasure of writing solutions in Scala.

Another important feature common to all of these libraries is their ability to compile 
[Solidity smart contracts](http://solidity.readthedocs.io/en/develop/introduction-to-smart-contracts.html); 
`web3j-scala` and `web3j` translate Solidity programs into Java code, 
while `web3.js` [emits JavaScript](https://github.com/ethereum/wiki/wiki/JavaScript-API) for `node.js` programs.
 
This project promotes idiomatic Scala in the following ways:
  - Variables and no-argument methods are actually names of properties, so `set` and `get` prefixes are not used.
    This means some properties do not have exactly the same name as their Web3J counterpart.
  - In general, zero-argument methods only require parentheses if they perform side effects.
  - Scala data types are used to the maximum extent that makes sense.
    For example, [scala.concurrent.Future](http://www.scala-lang.org/api/current/scala/concurrent/Future.html).
  - A functional programming style is encouraged by always returning immutable data types from methods.
    For example, [scala.collection.immutable.List](http://www.scala-lang.org/api/current/scala/collection/immutable/List.html)
    
`web3j` features RxJava extensions, and `web3j-scala` wraps that syntax in Scala goodness.
For example, the `web3j-scala` [observe methods](http://mslinn.github.io/web3j-scala/latest/api/com/micronautics/web3j/Web3JScala$.html)
provide [simple and efficient application code](https://github.com/mslinn/web3j-scala/blob/master/demo/DemoObservables.scala#L14-L22):
```
//  Display all new blocks as they are added to the blockchain:
observe(web3j.blockObservable(false)) { ethBlock =>
  println(format(ethBlock))
}

// Display only the first 10 new transactions as they are added to the blockchain:
observe(10)(web3j.transactionObservable) { tx =>
  println(format(tx))
}
```

<h2>Value Classes Provide Efficient Type Safety</h2>

Scala's [value classes are used](https://github.com/mslinn/web3j-scala/blob/master/src/main/scala/com/micronautics/web3j/ValueClasses.scala) 
to provide much stronger type safety than `web3j`, without incurring a runtime penalty.
Implicit conversions are provided that make it easy to obtain instances of the desired value classes, without sacrificing type safety.
For example, the following code implicitly converts the `String` returned by `basicInfoContract.send.getContractAddress`
into an `Address`:

    val basicInfoContractAddress: Address = basicInfoContract.send.getContractAddress

<p>
  Scala&rsquo;s <i>value classes</i> provide additional type safety without a runtime penalty by wrapping JVM code.
  <code>web3j-scala</code> does this by providing the following value classes:
</p>
<ul class="columns triple">
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/ValueClasses.scala#L6-L14"><code>Address</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/ValueClasses.scala#L17-L25"><code>BlockHash</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/ValueClasses.scala#L28-L36"><code>Compiler</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/ValueClasses.scala#L39-L47"><code>Digest</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/ValueClasses.scala#L50-L59"><code>EtHash</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/Ether.scala"><code>Ether</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/ValueClasses.scala#L62-L70"><code>FilterId</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/ValueClasses.scala#L73-L85"><code>Keccak256Hash</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/ValueClasses.scala#L88-L96"><code>LLLCompiled</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/ValueClasses.scala#L99-L107"><code>LLLSource</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/ValueClasses.scala#L110-L124"><code>Nonce</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/ValueClasses.scala#L127-L135"><code>Password</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/ValueClasses.scala#L138-L148"><code>PrivateKey</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/ValueClasses.scala#L151-L159"><code>PublicKey</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/package.scala#L72-L74"><code>RichBlock</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/ValueClasses.scala#L162-L170"><code>SerpentCompiled</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/ValueClasses.scala#L173-L181"><code>SerpentSource</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/ValueClasses.scala#L184-L192"><code>Signature</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/ValueClasses.scala#L195-L203"><code>SignedData</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/ValueClasses.scala#L206-L215"><code>SoliditySource</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/ValueClasses.scala#L218-L226 "><code>TransactionHash</code></a></li>
  <li><a href="https://github.com/mslinn/web3j-scala/blob/master/root/src/main/scala/com/micronautics/web3j/Wallet.scala"><code>Wallet</code></a></li>
</ul>
    
## A Few Words Of Explanation
A sample Solidity smart contract is in the `abiWrapper/com/micronautics/solidity` directory.
A Java file in the `abiWrapper` directory is created when SBT runs by compiling the Solidity smart contract provided with this project.
This line in `build.sbt` adds the `abiWrapper` directory to the collection of source code directories:

    unmanagedSourceDirectories in Compile += baseDirectory.value / "../abiWrapper"

## Use As a Library
Add this to your SBT project's `build.sbt`:

    resolvers ++= Seq(
      "ethereum" at "https://dl.bintray.com/ethereum/maven/",
      "micronautics/scala on bintray" at "http://dl.bintray.com/micronautics/scala"
    )

    libraryDependencies += "com.micronautics" %% "web3j-scala" % "0.2.0" withSources()

Only Scala 2.12 with JDK 8 is supported at present; this is a limitation of the Scala ecosystem as of November 7, 2017.

## Demos Require an Ethereum Client
An Ethereum client such as `geth` needs to be running before the demos can work.
The `bin/runGeth` script invokes `geth` with the following options, which are convenient for development 
but not secure enough for production:
 - The Ethereum data directory is set to `~/.ethereum`, or a subdirectory that depends on the network chosen; 
   the directory will be created if required.
 - HTTP-RPC server at `localhost:8545` is enabled, and all APIs are allowed.
 - Ethereum's experimental Whisper message facility is enabled.
 - Inter-process communication will be via a virtual file called `geth.ipc`, 
   located at `~/.ethereum` or a subdirectory.
 - WS-RPC server at `localhost:8546` is enabled, and all APIs are allowed.
 - Verbosity level `info` is specified.
 - A log file for the `geth` output will be written, or overwritten, in `logs/geth.log`;
   the `logs/` directory will be created if it does not already exist.

When you run the script you will see the message `No etherbase set and no accounts found as default`.
Etherbase is the index into `personal.listAccounts` which determines the account to send Ether too.
You can specify this value with the option `--etherbase 0`.

`geth` will continuously scroll output so long as it continues to run, so you must run the demo programs in another shell.

## Running the Demo Programs
The demo programs follow the general outline of the 
[web3j Getting Started](https://docs.web3j.io/getting_started.html#start-sending-requests) documentation, 
adapted for `web3j-scala`, including synchronous and asynchronous versions of the available methods.

Each demo program starts with a 
[DemoContext](https://github.com/mslinn/web3j-scala/blob/master/demo/DemoContext.scala), 
which performs some setup common to all the demo programs.
`DemoContext` demonstrates how to use `web3j-scala`'s 
[synchronous and asynchronous APIs](https://github.com/mslinn/web3j-scala/blob/master/demo/DemoContext.scala).

The demo programs are:
 - `DemoObservables` - `web3j`'s functional-reactive nature makes it easy to set up observers that notify subscribers of events taking place on the blockchain.
   This demo shows how to work with [RxJava's Observables from Scala](https://github.com/mslinn/web3j-scala/blob/master/demo/DemoObservables.scala).
 - `DemoSmartContracts` - Compiles an example Solidity program that defines a smart contract,
   [creates a JVM wrapper](https://github.com/mslinn/web3j-scala/blob/master/demo/DemoSmartContracts.scala) for the
   [sample smart contract](https://github.com/mslinn/web3j-scala/blob/master/src/test/resources/basic_info_getter.sol), 
   and exercises the smart contract from Scala.
 - `DemoTransaction` - Demonstrates enhanced support beyond what `web3j` provides for working with Ethereum wallet files
   and Ethereum client admin commands for sending 
   [transactions](https://github.com/mslinn/web3j-scala/blob/master/demo/DemoTransactions.scala).

The help message for the `bin/demo` script appears if you do not specify any arguments:
```
$ bin/demo
This script can run some or all of the web3j-scala demo programs.
An Ethereum client must be running before any of these demos will work.
If you have installed a recent version of the geth Ethereum client, run it as follows:

  bin/runGeth

Once geth is running, run a demo programs by typing the following into another console:

  bin/demo Observables     # Demonstrates how Scala works with the RxJava functionality provided with Web3J.
  bin/demo SmartContracts  # Demonstrates JVM wrappers around Ethereum smart contracts.
  bin/demo Transactions    # Demonstrates of Ethereum transactions using wallet files and the Ethereum client.
  bin/demo All             # Run all of the above
```

## More Scripts!
The following scripts are provided in the `bin/` directory:
- [bin/attachHttp](https://github.com/mslinn/web3j-scala/blob/master/bin/attachHttp) &ndash;
  Attach to a running Ethereum client via HTTP and open a 
  [JavaScript console](https://godoc.org/github.com/robertkrimen/otto)
- [bin/attachIpc](https://github.com/mslinn/web3j-scala/blob/master/bin/attachIpc) &ndash;
  Attach to a running Ethereum client via IPC and open a JavaScript console.
  This script might need to be edited if a network other than `devnet` is used.
- [bin/getApis](https://github.com/mslinn/web3j-scala/blob/master/bin/gethApis) &ndash;
  Reports the available APIs exposed by an Ethereum client.
- [bin/isGethListening](https://github.com/mslinn/web3j-scala/blob/master/bin/isGethListening) &ndash;
  Verifies that an Ethereum client is listening on HTTP port 8545
- [bin/web3j](https://github.com/mslinn/web3j-scala/blob/master/bin/web3j) &ndash; 
  Runs the [web3j command-line console](https://docs.web3j.io/command_line.html).
  The script builds a fat jar the first time it is run, so the command runs quickly on subsequent invocations.
  Invoke the script without any arguments to see the help message:
  ```
                _      _____ _     _
               | |    |____ (_)   (_)
  __      _____| |__      / /_     _   ___
  \ \ /\ / / _ \ '_ \     \ \ |   | | / _ \
   \ V  V /  __/ |_) |.___/ / | _ | || (_) |
    \_/\_/ \___|_.__/ \____/| |(_)|_| \___/
                           _/ |
                          |__/
  
  Usage: web3j version|wallet|solidity ...
  ```
  Now we know that the `web3j` script accepts three subcommand: `version`, `wallet` and `solidity`.
  To see the help message for `web3j wallet`, simply type that in:
  ```
  $ bin/web3j wallet
  
                _      _____ _     _
               | |    |____ (_)   (_)
  __      _____| |__      / /_     _   ___
  \ \ /\ / / _ \ '_ \     \ \ |   | | / _ \
   \ V  V /  __/ |_) |.___/ / | _ | || (_) |
    \_/\_/ \___|_.__/ \____/| |(_)|_| \___/
                           _/ |
                          |__/
  
  wallet create|update|send|fromkey
  ```
   
## Developers
### API Documentation
* [The Scaladoc for both the library and the demo is here](http://mslinn.github.io/web3j-scala/index.html); 
you can go directly to the [library Scaladoc](http://mslinn.github.io/web3j-scala/latest/api/root/com/micronautics/web3j/index.html) 
and the [demo Scaladoc](http://mslinn.github.io/web3j-scala/latest/api/demo/demo/index.html).

* [The web3j JavaDoc is here](https://jar-download.com/java-documentation-javadoc.php?a=core&g=org.web3j&v=3.0.2),
  and here is the [web3j gitter channel](https://gitter.im/web3j/web3j).

### Previewing Scaladoc
To preview Scaladoc, you can either run the `previewSite` task, which launches a static web server, or
run the `previewAuto` task, which launches a dynamic server that updates its content at each modification in your source files.
Both servers run from port 4000 and both SBT tasks attempt to connect your browser to `http://localhost:4000/`.

To change the server port, set `previewFixedPort`: 

    previewFixedPort := Some(9999)
   
### Publishing
1. Update the version string in `build.sbt` and in this `README.md` before attempting to publish to Bintray.
2. Commit changes with a descriptive comment:
   ```
   $ git add -a && git commit -m "Comment here"
   ```
3. Tell the `sbt-git` SBT plugin where the `.git` directory is:
   ```
   export GIT_DIR="$(pwd)/.git"
   ```
4. Publish a new version of this library, including committing changes and updating the Scaladoc with this command:
   ```
   $ sbt publishAndTag
   ```

### Updating Scaladoc
The documentation for this project is generated separately for both subprojects: `root` (the library) and `demo`.
For usage, simply type:
```
$ bin/doc
Publish 0.2.1
Usage: bin/doc [options]

  -a, --autoCheckIn <value>
                           Stop program if any files need to be committed or pushed
  -c, --copyright <value>  Scaladoc footer
  -d, --deleteAfterUse <value>
                           remove the GhPages temporary directory when the program ends
  -n, --gitHubName <value>
                           Github ID for project
  -o, --overWriteIndex <value>
                           Do not preserve any pre-existing index.html in the Scaladoc root
  -r, --dryRun <value>     Show the commands that would be run
  -s, --subProjectNames <value>
                           Comma-delimited names of subprojects to generate Scaladoc for
```

## Sponsorship and Proofs of Concept
<img src='https://www.micronauticsresearch.com/images/robotCircle400shadow.png' align='right' width='15%'>

To date this project has been sponsored by [Micronautics Research Corporation](http://www.micronauticsresearch.com/),
the company that delivers online Scala training via [ScalaCourses.com](http://www.ScalaCourses.com).

The only way to provide value is to serve customers.
We actively seek opportunities to develop blockchain-related prototypes and proofs of concept.
We would be happy to [present our work and discuss sponsorship opportunities](https://www.micronauticsresearch.com/portfolio.html#ethereum) for our open-source libraries.
Please [contact us](mailto:sales@micronauticsresearch.com) to discuss.

## License
This software is published under the [Apache 2.0 License](http://www.apache.org/licenses/LICENSE-2.0.html).
