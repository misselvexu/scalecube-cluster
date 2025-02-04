package io.scalecube.transport.netty;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Catching and logging exceptions.
 *
 * <p><b>NOTE:</b> this handler must be the last handler in the pipeline.
 */
@ChannelHandler.Sharable
final class ExceptionHandler extends ChannelDuplexHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

  @Override
  public final void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    LOGGER.debug("Exception caught for channel {}, {}", ctx.channel(), cause.toString());
  }
}
