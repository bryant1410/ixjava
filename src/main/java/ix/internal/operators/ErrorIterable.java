/*
 * Copyright 2011-2016 David Karnok
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ix.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterable sequence which throws a specific exception when the first element is retrieved.
 *
 * @param <T> the value type, ignored
 */
public final class ErrorIterable<T> implements Iterable<T> {
	/** The exception to throw on the first element. */
	private final Throwable t;
	/**
	 * Constructor, sets the exception.
	 * @param t the exception to throw
	 */
	public ErrorIterable(Throwable t) {
		this.t = t;
	}

	@Override
	public Iterator<T> iterator() {
	    return new Iterator<T>() {
	        /** First call? */
	        boolean first = true;
	        @Override
	        public boolean hasNext() {
	            return first;
	        }
	        
	        @Override
	        public T next() {
	            if (first) {
	                first = false;
	                if (t instanceof RuntimeException) {
	                    throw (RuntimeException)t;
	                }
	                throw new RuntimeException(t);
	            }
	            throw new NoSuchElementException();
	        }
	        
	        @Override
	        public void remove() {
	            throw new IllegalStateException();
	        }
	        
	    };
	}
}