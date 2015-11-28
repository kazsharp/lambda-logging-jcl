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

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.logging.log4j.jcl.LogFactoryImpl;
import org.apache.logging.log4j.spi.LoggerAdapter;

/**
 * ラムダ式の遅延実行により無駄な文字列生成を行わない、Log4j2用commons-logginのLogFactory実装クラス。
 */
public class LambdaLogFactoryImpl extends LogFactoryImpl {

	private final LoggerAdapter<Log> adapter = new LambdaLogAdapter();

	/*
	 * (非 Javadoc)
	 *
	 * @see
	 * org.apache.logging.log4j.jcl.LogFactoryImpl#getInstance(java.lang.String)
	 */
	@Override
	public Log getInstance(final String name) throws LogConfigurationException {
		return adapter.getLogger(name);
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see org.apache.logging.log4j.jcl.LogFactoryImpl#release()
	 */
	@Override
	public void release() {
		try {
			adapter.close();
		} catch (final IOException ignored) {
		}
	}
}
