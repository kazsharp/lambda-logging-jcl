/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */
package jp.gr.java_conf.kazsharp.lambda_logging.jcl;

import java.io.Serializable;
import java.util.function.Supplier;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.jcl.Log4jLog;
import org.apache.logging.log4j.spi.ExtendedLogger;

/**
 * ラムダ式の遅延実行により無駄な文字列生成を行わない、Log4j2用commons-logginのLog実装クラス。
 */
public class LambdaLog4jLog extends Log4jLog implements Log, Serializable {

	private static final long serialVersionUID = 1L;
	private static final String FQCN = LambdaLog4jLog.class.getName();

	private ExtendedLogger logger;

	/**
	 * コンストラクタ。
	 *
	 * @param logger
	 */
	public LambdaLog4jLog(final ExtendedLogger logger) {
		super(logger);
		this.logger = logger;
	}

	private void logIfEnabled(Level level, Supplier<String> message) {
		if (logger.isEnabled(level)) {
			logger.logIfEnabled(FQCN, level, null, message.get());
		}
	}

	private void logIfEnabled(Level level, Supplier<String> message, Throwable t) {
		if (logger.isEnabled(level)) {
			logger.logIfEnabled(FQCN, level, null, message.get(), t);
		}
	}

	/**
	 * TRACEレベルのログを出力する。
	 *
	 * @param message
	 *            メッセージを遅延生成するSupplierオブジェクト(lambda式)
	 */
	public void trace(final Supplier<String> message) {
		logIfEnabled(Level.TRACE, message);
	}

	/**
	 * TRACEレベルのログを出力する。
	 *
	 * @param message
	 *            メッセージを遅延生成するSupplierオブジェクト(lambda式)
	 * @param t
	 *            Throwableオブジェクト
	 */
	public void trace(final Supplier<String> message, final Throwable t) {
		logIfEnabled(Level.TRACE, message, t);
	}

	/**
	 * DEBUGレベルのログを出力する。
	 *
	 * @param message
	 *            メッセージを遅延生成するSupplierオブジェクト(lambda式)
	 */
	public void debug(final Supplier<String> message) {
		logIfEnabled(Level.DEBUG, message);
	}

	/**
	 * DEBUGレベルのログを出力する。
	 *
	 * @param message
	 *            メッセージを遅延生成するSupplierオブジェクト(lambda式)
	 * @param t
	 *            Throwableオブジェクト
	 */
	public void debug(final Supplier<String> message, final Throwable t) {
		logIfEnabled(Level.DEBUG, message, t);
	}

	/**
	 * INFOレベルのログを出力する。
	 *
	 * @param message
	 *            メッセージを遅延生成するSupplierオブジェクト(lambda式)
	 */
	public void info(final Supplier<String> message) {
		logIfEnabled(Level.INFO, message);
	}

	/**
	 * INFOレベルのログを出力する。
	 *
	 * @param message
	 *            メッセージを遅延生成するSupplierオブジェクト(lambda式)
	 * @param t
	 *            Throwableオブジェクト
	 */
	public void info(final Supplier<String> message, final Throwable t) {
		logIfEnabled(Level.INFO, message, t);
	}

	/**
	 * WARNレベルのログを出力する。
	 *
	 * @param message
	 *            メッセージを遅延生成するSupplierオブジェクト(lambda式)
	 */
	public void warn(final Supplier<String> message) {
		logIfEnabled(Level.WARN, message);
	}

	/**
	 * WARNレベルのログを出力する。
	 *
	 * @param message
	 *            メッセージを遅延生成するSupplierオブジェクト(lambda式)
	 * @param t
	 *            Throwableオブジェクト
	 */
	public void warn(final Supplier<String> message, final Throwable t) {
		logIfEnabled(Level.WARN, message, t);
	}

	/**
	 * ERRORレベルのログを出力する。
	 *
	 * @param message
	 *            メッセージを遅延生成するSupplierオブジェクト(lambda式)
	 */
	public void error(final Supplier<String> message) {
		logIfEnabled(Level.ERROR, message);
	}

	/**
	 * ERRORレベルのログを出力する。
	 *
	 * @param message
	 *            メッセージを遅延生成するSupplierオブジェクト(lambda式)
	 * @param t
	 *            Throwableオブジェクト
	 */
	public void error(final Supplier<String> message, final Throwable t) {
		logIfEnabled(Level.ERROR, message, t);
	}

	/**
	 * FATALレベルのログを出力する。
	 *
	 * @param message
	 *            メッセージを遅延生成するSupplierオブジェクト(lambda式)
	 */
	public void fatal(final Supplier<String> message) {
		logIfEnabled(Level.FATAL, message);
	}

	/**
	 * FATALレベルのログを出力する。
	 *
	 * @param message
	 *            メッセージを遅延生成するSupplierオブジェクト(lambda式)
	 * @param t
	 *            Throwableオブジェクト
	 */
	public void fatal(final Supplier<String> message, final Throwable t) {
		logIfEnabled(Level.FATAL, message, t);
	}

}
