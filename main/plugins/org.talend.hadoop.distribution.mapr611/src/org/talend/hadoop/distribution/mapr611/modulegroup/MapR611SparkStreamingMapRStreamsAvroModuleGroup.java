// ============================================================================
//
// Copyright (C) 2006-2020 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.hadoop.distribution.mapr611.modulegroup;

import java.util.HashSet;
import java.util.Set;

import org.talend.core.hadoop.version.EHadoopDistributions;
import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.condition.common.SparkStreamingLinkedNodeCondition;
import org.talend.hadoop.distribution.constants.SparkStreamingConstant;
import org.talend.hadoop.distribution.mapr611.MapR611Constant;
import org.talend.hadoop.distribution.mapr611.MapR611Distribution;

public class MapR611SparkStreamingMapRStreamsAvroModuleGroup {

    public static Set<DistributionModuleGroup> getModuleGroups() {
        Set<DistributionModuleGroup> hs = new HashSet<>();
        // This is not a typo on the module group. Both Kafka and MapR Streams share the same Avro dependencies.
        DistributionModuleGroup dmg = new DistributionModuleGroup(
                MapR611Constant.SPARK_KAFKA_AVRO_MRREQUIRED_MODULE_GROUP.getModuleName(), true,
                new SparkStreamingLinkedNodeCondition(EHadoopDistributions.MAPR.getName(), MapR611Distribution.VERSION,
                        SparkStreamingConstant.MAPRSTREAMS_SPARKCONFIGURATION_LINKEDPARAMETER).getCondition());
        hs.add(dmg);
        // Add Spark Streaming MapR Streams dependencies as well
        hs.addAll(MapR611SparkStreamingMapRStreamsAssemblyModuleGroup.getModuleGroups());
        return hs;
    }
}