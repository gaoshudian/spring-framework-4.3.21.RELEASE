/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.type.classreading;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.asm.ClassReader;
import org.springframework.core.NestedIOException;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;

/**
 * 描述: SimpleMetadataReader 为MetadataReader的默认实现，在创建SimpleMetadataReader时
 * 通过ASM{@link org.springframework.asm.ClassReader}字节码操控框架读取class资源流生成
 * classMetadata与annotationMetadata
 *
 * @Auther: gaoshudian
 * @Date: 2019/10/21 9:41 PM
 * @since 2.5
 */
final class SimpleMetadataReader implements MetadataReader {

	//class类IO流资源引用
	private final Resource resource;

    //class类元数据
	private final ClassMetadata classMetadata;

    //class类完整注释元数据
	private final AnnotationMetadata annotationMetadata;


    /**
     * 构建函数，用于通过 ASM字节码操控框架 读取class读取class资源流
     */
	SimpleMetadataReader(Resource resource, ClassLoader classLoader) throws IOException {
        // 获取class类IO流
	    InputStream is = new BufferedInputStream(resource.getInputStream());
		ClassReader classReader;
		try {
            //通过ASM字节码操控框架读取class
			classReader = new ClassReader(is);
		}
		catch (IllegalArgumentException ex) {
			throw new NestedIOException("ASM ClassReader failed to parse class file - " +
					"probably due to a new Java class file version that isn't supported yet: " + resource, ex);
		}
		finally {
			is.close();
		}
        //注解元数据读取访问者读取注解元数据
		AnnotationMetadataReadingVisitor visitor = new AnnotationMetadataReadingVisitor(classLoader);
		classReader.accept(visitor, ClassReader.SKIP_DEBUG);

        //注解元数据
		this.annotationMetadata = visitor;
		////class元数据 (AnnotationMetadataReadingVisitor类继承ClassMetadataReadingVisitor)
		this.classMetadata = visitor;
		this.resource = resource;
	}


	@Override
	public Resource getResource() {
		return this.resource;
	}

	@Override
	public ClassMetadata getClassMetadata() {
		return this.classMetadata;
	}

	@Override
	public AnnotationMetadata getAnnotationMetadata() {
		return this.annotationMetadata;
	}

}
