/**
Copyright (c) 2018-present, Walmart, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.walmartlabs.x12.asn856;

import com.walmartlabs.x12.X12Segment;
import com.walmartlabs.x12.common.AbstractStandardX12Parser;
import com.walmartlabs.x12.exceptions.X12ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * ASN 856 is the Advance Shipping Notice Used to communicate the contents of a shipment prior to arriving at the facility where the contents will be
 * delivered.
 *
 */
public class DefaultAsn856Parser extends AbstractStandardX12Parser<Asn856> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAsn856Parser.class);

    /**
     * parse the ASN 856 transmission into a representative Java object
     *
     * @return {@link Asn856}
     * @throws X12ParserException
     */
    @Override
    public Asn856 parse(String sourceData) {
        Asn856 asn856 = null;

        if (!StringUtils.isEmpty(sourceData)) {
            asn856 = new Asn856();
            List<X12Segment> segmentLines = this.splitSourceDataIntoSegments(sourceData);
            // TODO: implement the parser
            int segmentIdx = 0;
            this.parseInterchangeControlHeader(segmentLines.get(segmentIdx), asn856);
        }

        return asn856;
    }

}
