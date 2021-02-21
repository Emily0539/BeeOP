/*
 * Copyright Chris2018998
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.beeop.pool;

import cn.beeop.BeeObjectException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Proxy reflect handle
 *
 * @author Chris.Liao
 * @version 1.0
 */
public class ProxyReflect extends ProxyWrapper implements InvocationHandler {
    public ProxyReflect(PooledEntry pEntry) {
        super(pEntry);
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        if (isClosed) throw new BeeObjectException();
        return method.invoke(rawObject, args);
    }
}
