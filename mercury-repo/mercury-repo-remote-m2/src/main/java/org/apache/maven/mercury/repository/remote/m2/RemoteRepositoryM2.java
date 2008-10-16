package org.apache.maven.mercury.repository.remote.m2;

import org.apache.maven.mercury.builder.api.DependencyProcessor;
import org.apache.maven.mercury.repository.api.AbstractRepository;
import org.apache.maven.mercury.repository.api.LocalRepository;
import org.apache.maven.mercury.repository.api.NonExistentProtocolException;
import org.apache.maven.mercury.repository.api.RemoteRepository;
import org.apache.maven.mercury.repository.api.RepositoryException;
import org.apache.maven.mercury.repository.api.RepositoryReader;
import org.apache.maven.mercury.repository.api.RepositoryUpdateIntervalPolicy;
import org.apache.maven.mercury.repository.api.RepositoryUpdatePolicy;
import org.apache.maven.mercury.repository.api.RepositoryWriter;
import org.apache.maven.mercury.transport.api.Server;


public class RemoteRepositoryM2
extends AbstractRepository
implements RemoteRepository
{
    private Server _server;
    
    /** default update policy */
    private RepositoryUpdatePolicy _updatePolicy = new RepositoryUpdateIntervalPolicy( RepositoryUpdateIntervalPolicy.DEFAULT_UPDATE_POLICY );
    
    //----------------------------------------------------------------------------------
    public RemoteRepositoryM2( Server server  )
    {
      this( server.getId(), server );
    }
    //----------------------------------------------------------------------------------
    public RemoteRepositoryM2( String id, Server server  )
    {
        super( id, DEFAULT_REPOSITORY_TYPE );
        this._server = server;
    }
    //----------------------------------------------------------------------------------
    public Server getServer()
    {
        return _server;
    }
    //----------------------------------------------------------------------------------
    public RepositoryReader getReader( DependencyProcessor processor )
    throws RepositoryException
    {
      return new RemoteRepositoryReaderM2( this, processor );
    }
    //----------------------------------------------------------------------------------
    public RepositoryReader getReader( DependencyProcessor processor, String protocol )
    throws RepositoryException
    {
      return getReader(processor);
    }
    //----------------------------------------------------------------------------------
    public RepositoryWriter getWriter()
    throws RepositoryException
    {
      return new RemoteRepositoryWriterM2(this);
    }
    //----------------------------------------------------------------------------------
    public RepositoryWriter getWriter( String protocol )
        throws NonExistentProtocolException
    {
      // TODO Auto-generated method stub
      return null;
    }
    //----------------------------------------------------------------------------------
    public boolean isLocal()
    {
     return false;
    }
    //----------------------------------------------------------------------------------
    public boolean isReadOnly()
    {
      return false;
    }
    //----------------------------------------------------------------------------------
    public String getType()
    {
      return DEFAULT_REPOSITORY_TYPE;
    }
    //----------------------------------------------------------------------------------

    public RepositoryUpdatePolicy getUpdatePolicy()
    {
      return _updatePolicy;
    }

    public void setUpdatePolicy( RepositoryUpdatePolicy updatePolicy )
    {
      this._updatePolicy = updatePolicy;
    }
    
    //----------------------------------------------------------------------------------
    /* (non-Javadoc)
     * @see org.apache.maven.mercury.repository.api.RemoteRepository#addLocalRepository(org.apache.maven.mercury.repository.api.LocalRepository)
     */
    public void addLocalRepository( LocalRepository localRepo )
    {
      // TODO Auto-generated method stub
      
    }
}
