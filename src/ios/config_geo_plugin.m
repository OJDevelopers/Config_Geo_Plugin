//
//  config_geo_plugin.m
//  config_geo_plugin
//
//  Created by ALSephirot on 05/11/2015
//
//

#import "config_geo_plugin.h"

@implementation config_geo_plugin

- (void)open:(CDVInvokedUrlCommand*)command
{
        NSURL *appSettings = [NSURL URLWithString:UIApplicationOpenSettingsURLString];
        [[UIApplication sharedApplication] openURL:appSettings];
}

@end
